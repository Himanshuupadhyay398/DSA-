class Solution {
    Integer dp[][][];
    int mod=(int)1e9+7;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp=new Integer[51][51][51];
        return solve(m,n,maxMove,startRow,startColumn);
    }
    public int solve(int m, int n,int moveAtTime,int i,int j){

        if(i<0 || j<0 || i>=m || j>=n){
            return 1;
        }
        if(moveAtTime==0) return 0;
        if(dp[moveAtTime][i][j]!=null) return dp[moveAtTime][i][j];

        int up=solve(m,n,moveAtTime-1,i-1,j);
        int down=solve(m,n,moveAtTime-1,i+1,j);
        int right=solve(m,n,moveAtTime-1,i,j+1);
        int left=solve(m,n,moveAtTime-1,i,j-1);
        return dp[moveAtTime][i][j]=((left+right)%mod+(up+down)%mod)%mod;
    }
}