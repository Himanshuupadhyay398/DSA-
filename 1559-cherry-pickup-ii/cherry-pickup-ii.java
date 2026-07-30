class Solution {
    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int dp[][][]=new int[n][m][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return recurse(grid,0,0,m-1,dp);
    }

    public int recurse(int grid[][],int r1,int col1,int col2,int dp[][][]){
        int n=grid.length;
        int m=grid[0].length;

        if(col1<0 || col1>=m || col2<0 || col2>=m){
            return Integer.MIN_VALUE;
        }

        if(r1==n-1){
            if(col1==col2){
                return grid[r1][col1];
            }

            return grid[r1][col1]+grid[r1][col2];
        }

        if(dp[r1][col1][col2]!=-1) return dp[r1][col1][col2];
        int max=0;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){

                if(col1==col2){
                    dp[r1][col1][col2]=Math.max(dp[r1][col1][col2],grid[r1][col1]+recurse(grid,r1+1,col1+i,col2+j,dp));
                }else{
                    dp[r1][col1][col2]=Math.max(dp[r1][col1][col2],grid[r1][col2]+grid[r1][col1]+recurse(grid,r1+1,col1+i,col2+j,dp));
                }
                max=Math.max(max,dp[r1][col1][col2]);
            }
        }
    return max;
    }
}