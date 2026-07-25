class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int dp[][] = new int[n][m];

        //     for(int i=0;i<n;i++){
        //         Arrays.fill(dp[i],-1);
        //     }
        //     return recurse(obstacleGrid,dp,n-1,m-1);
        // }
        // public int recurse(int [][]obstacleGrid,int [][]dp,int i ,int j){
        //     if(i<0 || j<0) return 0;

        //     if(obstacleGrid[i][j]==1) return 0;

        //     if(i==0 && j==0){
        //         return 1;
        //     }
        //     if(dp[i][j]!=-1) return dp[i][j];
        //     int first=recurse(obstacleGrid,dp,i-1,j);
        //     int second=recurse(obstacleGrid,dp,i,j-1);
        //     return dp[i][j]=first+second;
        if (obstacleGrid[0][0] == 1)
            return 0;

        if (obstacleGrid[n - 1][m - 1] == 1)
            return 0;

        dp[n - 1][m - 1] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 && j == m - 1)
                    continue;

                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                int up = 0;
                int left = 0;
                if (i + 1 < n) {
                    up = dp[i + 1][j];
                }
                if (j + 1 < m) {
                    left = dp[i][j + 1];
                }
                dp[i][j] = up + left;
            }
        }
        return dp[0][0];
    }
}