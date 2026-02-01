class Solution {
    // int dp[][]=new int[101][101];
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        // for(int i=0;i<n;i++){
        //     Arrays.fill(dp[i],Integer.MAX_VALUE);
        // }
    //     int result=Integer.MAX_VALUE;
    //     for(int i=0;i<n;i++){
    //         result=Math.min(result,recurse(matrix,0,i,n));
    //     }
    // return result;
    // }
    // public int recurse(int [][] matrix,int i,int j,int n){
    //     if(j<0 || j>=n) return Integer.MAX_VALUE;
    //     if(i==n-1) return matrix[i][j];
    //     if(dp[i][j]!=Integer.MAX_VALUE) return dp[i][j];

    //     int left=recurse(matrix,i+1,j-1,n);
    //     int down=recurse(matrix,i+1,j,n);
    //     int right=recurse(matrix,i+1,j+1,n);

    //     return dp[i][j]=matrix[i][j]+Math.min(down,Math.min(left,right));
    // } 

    // tabulation

        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++){
            dp[0][i]=matrix[0][i];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                // just trying ot stay top down way form top to bottom that why we check from up ,left up ,right up
                //just like down,down left,down right
                int up=dp[i-1][j];

                int leftup=(j>0)?dp[i-1][j-1]:Integer.MAX_VALUE;

                int rightup= (j<n-1) ? dp[i-1][j+1] : Integer.MAX_VALUE;

                dp[i][j]=matrix[i][j]+Math.min(up,Math.min(leftup,rightup));
            }
        }
        int result=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            result=Math.min(result,dp[n-1][i]);
        }
    return result;
    }
}