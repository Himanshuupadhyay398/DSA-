class Solution {
    int dp[]=new int[46];
    public int climbStairs(int n) {
        Arrays.fill(dp,-1);
        return recurse(n,0);
    }
    public int recurse(int n,int idx){
        if(idx==n){
            return 1;
        }
        if(idx>n) return 0;
        if(dp[idx]!=-1) return dp[idx];
        dp[idx]=recurse(n,idx+1)+recurse(n,idx+2);
    return dp[idx];
    }
}