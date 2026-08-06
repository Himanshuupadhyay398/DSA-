class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int dp[][]=new int[n+1][amount+1];
        Arrays.fill(dp[n],amount+1);
        dp[n][0]=0;
        for(int i=n-1;i>=0;i--){
            for(int j=1;j<=amount;j++){
                    if(coins[i]<=j) dp[i][j]=Math.min(dp[i][j-coins[i]]+1,dp[i+1][j]);
                    else dp[i][j]=dp[i+1][j];
            }
        }
    return dp[0][amount]==amount+1?-1:dp[0][amount];
    }
}















