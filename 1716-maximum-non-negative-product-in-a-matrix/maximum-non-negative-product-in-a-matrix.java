class pair{
    long max;
    long min;

    pair(long max,long min){
        this.max=max;
        this.min=min;
    }
}
class Solution {
    pair dp[][];
    public int maxProductPath(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        dp=new pair[n][m];
        int mod=1000000007;
        pair result=recurse(grid,0,0);
        long answer=result.max;
        if(answer<0){
            return -1;
        }
        return (int)(answer%mod);
    }
    public pair recurse(int grid[][],int i,int j){
        int n=grid.length;
        int m=grid[0].length;
        if(i==n-1 && j==m-1) {
            return new pair(grid[i][j],grid[i][j]);
        }
        long maxval=Long.MIN_VALUE;
        long minval=Long.MAX_VALUE;
        if(dp[i][j]!=null) return dp[i][j];

        if(i+1<n){
            pair down=recurse(grid,i+1,j);
            maxval=Math.max(maxval,Math.max(grid[i][j]*down.max,grid[i][j]*down.min));
            minval=Math.min(minval,Math.min(grid[i][j]*down.max,grid[i][j]*down.min));
        }
        if(j+1<m){
            pair right=recurse(grid,i,j+1);
            maxval=Math.max(maxval,Math.max(grid[i][j]*right.max,grid[i][j]*right.min));
            minval=Math.min(minval,Math.min(grid[i][j]*right.max,grid[i][j]*right.min));
        }

        return dp[i][j]=new pair(maxval,minval);
    
    }
}