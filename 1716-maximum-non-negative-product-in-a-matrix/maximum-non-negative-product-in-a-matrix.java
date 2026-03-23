class pair {
    long max;
    long min;

    pair(long max, long min) {
        this.max = max;
        this.min = min;
    }
}

class Solution {
    pair dp[][];

    public int maxProductPath(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        dp=new pair[n][m];
        int mod=1000000007;
        // pair result=recurse(grid,0,0);
    //     long answer=result.max;
    //     if(answer<0){
    //         return -1;
    //     }
    //     return (int)(answer%mod);
    // }
    // public pair recurse(int grid[][],int i,int j){
    //     int n=grid.length;
    //     int m=grid[0].length;
    //     if(i==n-1 && j==m-1) {
    //         return new pair(grid[i][j],grid[i][j]);
    //     }
    //     long maxval=Long.MIN_VALUE;
    //     long minval=Long.MAX_VALUE;
    //     if(dp[i][j]!=null) return dp[i][j];

    //     if(i+1<n){
    //         pair down=recurse(grid,i+1,j);
    //         maxval=Math.max(maxval,Math.max(grid[i][j]*down.max,grid[i][j]*down.min));
    //         minval=Math.min(minval,Math.min(grid[i][j]*down.max,grid[i][j]*down.min));
    //     }
    //     if(j+1<m){
    //         pair right=recurse(grid,i,j+1);
    //         maxval=Math.max(maxval,Math.max(grid[i][j]*right.max,grid[i][j]*right.min));
    //         minval=Math.min(minval,Math.min(grid[i][j]*right.max,grid[i][j]*right.min));
    //     }

    //     return dp[i][j]=new pair(maxval,minval);


        //tabulation
        dp[0][0]=new pair(grid[0][0],grid[0][0]);
        for(int i=1;i<n;i++){
            dp[i][0]=new pair((dp[i-1][0].max*grid[i][0]),(dp[i-1][0].min*grid[i][0]));
        }
        for(int i=1;i<m;i++){
            dp[0][i]=new pair((dp[0][i-1].max*grid[0][i]),(dp[0][i-1].min*grid[0][i]));
        }
        long maxval=Long.MIN_VALUE;
        long minval=Long.MAX_VALUE;
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                
                long upmax = dp[i - 1][j].max;
                long upmin = dp[i - 1][j].min;

                long leftmax = dp[i][j - 1].max;
                long leftmin = dp[i][j - 1].min;

               dp[i][j] = new pair(
                    Math.max(
                        Math.max(upmax * grid[i][j], upmin * grid[i][j]),
                        Math.max(leftmax * grid[i][j], leftmin * grid[i][j])
                    ),
                    Math.min(
                        Math.min(upmax * grid[i][j], upmin * grid[i][j]),
                        Math.min(leftmax * grid[i][j], leftmin * grid[i][j])
                    )
                );
            }
        }
        long result=dp[n-1][m-1].max;
        if(result<0) return -1;
        return (int)(result%mod);
    }
}