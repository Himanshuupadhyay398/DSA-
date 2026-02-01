class Solution {
    public int minPathSum(int[][] grid) {
    //     int n=grid.length;
    //     int m=grid[0].length;
    //     int dp[][]=new int[n][m];
    //     for(int i=0;i<n;i++){
    //         Arrays.fill(dp[i],-1);
    //     }
        
    //     return totalpathMin(dp,grid,n-1,m-1);
    // }
    // public int totalpathMin(int dp[][],int grid[][],int i,int j){
    //     if(i<0 || j<0) return Integer.MAX_VALUE;
    //     if(i==0 && j==0) return grid[i][j];
    //     if(dp[i][j]!=-1) return dp[i][j];
    //     return dp[i][j]=grid[i][j] + Math.min(totalpathMin(dp,grid,i-1,j),totalpathMin(dp,grid,i,j-1));
    // }
    int n=grid.length;
    int m=grid[0].length;
    int dp[][]=new int[n][m];

    for(int i=n-1;i>=0;i--){
        for(int j=m-1;j>=0;j--){

            if(i==n-1 && j==m-1){
                dp[i][j]=grid[i][j];
            }
            else if(i==n-1){
                dp[i][j]=grid[i][j]+dp[i][j+1];
            }
            else if(j==m-1){
                dp[i][j]=grid[i][j]+dp[i+1][j];
            }
            else{
                dp[i][j]=grid[i][j]+Math.min(dp[i+1][j],dp[i][j+1]);
            }
        }
    }
    return dp[0][0];
    }
}
