class Solution {
    public boolean canPartitionGrid(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        long horizontal[] = new long[n];
        long vertical[] = new long[m];

        long total=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                total += grid[i][j];
                horizontal[i]+=grid[i][j];
                vertical[j]+=grid[i][j];
            }
        }

        
        if(total%2!=0) return false;
        long prefix = 0;
        for (int i = 0; i < n; i++) {
            prefix += horizontal[i];
            if (prefix == total-prefix) {
                return true;
            }
        }
        long prefix1 = 0;
        for (int i = 0; i < m; i++) {
            prefix1 += vertical[i];
            if (prefix1 == total-prefix1) {
                return true;
            }
        }

        return false;
    }
}