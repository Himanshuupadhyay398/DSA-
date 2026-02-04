class Solution {

    public long maxSumTrionic(int[] nums) {

        int n = nums.length;
        long res = -1 * (long)1e16;

        for (int b = 1; b < n - 2; b++) {

            int a = b;
            int c = b;

            long net = nums[a];

            while (c + 1 < n && nums[c + 1] < nums[c]) {
                net += nums[c + 1];
                c++;
            }

            if (c == a) continue;

            long left = 0;
            long right = 0;
            long lx = Integer.MIN_VALUE;
            long rx = Integer.MIN_VALUE;

            while (a - 1 >= 0 && nums[a - 1] < nums[a]) {
                left += nums[a - 1];
                lx = Math.max(lx, left);
                a--;
            }

            if (a == b) continue;

            while (c + 1 < n && nums[c + 1] > nums[c]) {
                right += nums[c + 1];
                rx = Math.max(rx, right);
                c++;
            }

            if (c == b) continue;

            b = c - 1;
            res = Math.max(res, lx + rx + net);
        }

        return res;
    }
}
