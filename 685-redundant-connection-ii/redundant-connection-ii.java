class Solution {
    static class DisjointSet {
        int[] parent;
        int[] size;

        DisjointSet(int n) {
            parent = new int[n + 1];
            size = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        // Find with path compression
        int find(int node) {
            if (parent[node] != node)
                parent[node] = find(parent[node]);
            return parent[node];
        }

        // Union by size
        // Returns false if cycle is detected
        boolean union(int u, int v) {
            int pu = find(u);
            int pv = find(v);

            if (pu == pv)
                return false; // cycle detected

            if (size[pu] < size[pv]) {
                parent[pu] = pv;
                size[pv] += size[pu];
            } else {
                parent[pv] = pu;
                size[pu] += size[pv];
            }

            return true;
        }
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;

        // Step 1: Track parent of each node (for detecting 2 parents)
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++)
            parent[i] = -1;

        // Two conflicting edges (if node has two parents)
        int[] edge1 = null; // earlier edge
        int[] edge2 = null; // later edge

        // Step 2: Detect node with two parents
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if (parent[v] != -1) {
                // Node v already has a parent → two parents found
                edge1 = new int[] { parent[v], v };
                edge2 = edge;
            } else {
                parent[v] = u;
            }
        }

        // Step 3: DSU to detect cycle
        DisjointSet dsu = new DisjointSet(n);

        for (int[] edge : edges) {

            // Skip second edge if two-parent case exists
            if (edge2 != null &&
                    edge[0] == edge2[0] &&
                    edge[1] == edge2[1]) {
                continue;
            }

            // If union fails → cycle detected
            if (!dsu.union(edge[0], edge[1])) {

                // Case: cycle + two parents
                if (edge1 != null)
                    return edge1;

                // Case: only cycle
                return edge;
            }
        }

        // Case: no cycle, but two parents
        return edge2; 
    }
}