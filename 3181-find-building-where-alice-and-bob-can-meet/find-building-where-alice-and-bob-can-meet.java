class Solution {
    int seg[];
    int n;
    int result[];

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        n = heights.length;
        result = new int[queries.length];
        seg = new int[4 * n];
        build(0, 0, n - 1, heights);
        for (int i = 0; i < queries.length; i++) {
            int alice = queries[i][0];
            int bob = queries[i][1];

            if (alice == bob) {
                result[i] = alice;
                continue;
            }
            if (alice > bob) {
                int temp = alice;
                alice = bob;
                bob = temp;
            }
            if (heights[bob] > heights[alice]) {
                result[i] = bob;
                continue;
            }

            int idxHelper = Integer.MAX_VALUE;
            int l = bob + 1, r = n - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                int index = query(0, 0, n - 1, l, mid,heights);
                if (heights[index] > Math.max(heights[alice], heights[bob])) {
                    r = mid - 1;
                    idxHelper = Math.min(index, idxHelper);
                } else {
                    l = mid + 1;
                }

            }
            result[i] = (idxHelper == Integer.MAX_VALUE) ? -1 : idxHelper;
        }
        return result;
    }

    public void build(int node, int l, int r, int heights[]) {
        if (l == r) {
            seg[node] = l;
            return;
        }
        int mid = l + (r - l) / 2;
        build(2 * node + 1, l, mid, heights);
        build(2 * node + 2, mid + 1, r, heights);
        seg[node] = (heights[seg[2 * node + 1]] >= heights[seg[2 * node + 2]]) ? seg[2 * node + 1] : seg[2 * node + 2];

    }

    public int query(int node, int l, int r, int ql, int qr,int heights[]) {
        if (l > qr || r < ql)
            return -1;
        if (l >= ql && r <= qr)
            return seg[node];

        int mid = l + (r - l) / 2;
        int leftmax = query(2 * node + 1, l, mid, ql, qr,heights);
        int rightmax = query(2 * node + 2, mid + 1, r, ql, qr,heights);
        if (leftmax == -1)
            return rightmax;
        if (rightmax == -1)
            return leftmax;

        return (heights[leftmax] >= heights[rightmax]) ? leftmax : rightmax;
    }
}