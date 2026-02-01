class Solution {
    int dp[][]=new int[101][101];
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        int result=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            result=Math.min(result,recurse(matrix,0,i,n));
        }
    return result;
    }
    public int recurse(int [][] matrix,int i,int j,int n){
        if(j<0 || j>=n) return Integer.MAX_VALUE;
        if(i==n-1) return matrix[i][j];
        if(dp[i][j]!=Integer.MAX_VALUE) return dp[i][j];

        int left=recurse(matrix,i+1,j-1,n);
        int down=recurse(matrix,i+1,j,n);
        int right=recurse(matrix,i+1,j+1,n);

        return dp[i][j]=matrix[i][j]+Math.min(down,Math.min(left,right));
    } 
}