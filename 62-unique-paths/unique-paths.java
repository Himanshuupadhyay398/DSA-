class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];
    //     for(int i=0;i<m;i++){
    //         Arrays.fill(dp[i],-1);
    //     }

    //     return recurse(dp,0,0,m,n);
    // }
    // public int recurse(int dp[][],int i,int j,int m,int n){
    //     if(i==m-1 && j==n-1) return 1;

    //     if(i>=m || j>=n) return 0;

    //     if(dp[i][j]!=-1) return dp[i][j];
    //     int down=recurse(dp,i+1,j,m,n);
    //     int right=recurse(dp,i,j+1,m,n);

    //     return dp[i][j]=down+right;
    
        dp[m-1][n-1]=1;
        for(int i=m-1;i>=0;i--){
           for(int j=n-1;j>=0;j--){
            int down=0,right=0;
            if(i==m-1 && j==n-1) continue;
                if(i+1<m){
                    down=dp[i+1][j];
                }
                if(j+1<n){
                    right=dp[i][j+1];
                }
                dp[i][j]=down+right;
           } 
        }
    return dp[0][0];
    }

}