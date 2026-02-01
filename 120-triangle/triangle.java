class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        return recurse(triangle,dp,0,0,n);
       
    }
    public int recurse(List<List<Integer>> triangle,int dp[][],int i,int j,int n){

        if(i==n-1) return triangle.get(i).get(j);

        if(dp[i][j]!=Integer.MAX_VALUE) return dp[i][j];

        int take=recurse(triangle,dp,i+1,j,n);
        int skip=recurse(triangle,dp,i+1,j+1,n);

        return dp[i][j]=triangle.get(i).get(j)+Math.min(take,skip);
    } 
}