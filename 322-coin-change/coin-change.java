class Solution {
    public int coinChange(int[] coins, int amount) {
    int dp[]=new int[amount+1];
    Arrays.fill(dp,-1);
    int answer=recurse(coins,amount,dp);
    return answer==Integer.MAX_VALUE?-1:answer;
    }
    public int recurse(int coins[],int amount,int dp[]){
        if(amount==0) return 0;
        if(amount<0) return Integer.MAX_VALUE;

        if(dp[amount]!=-1) return dp[amount];

       int min = Integer.MAX_VALUE;

        for (int coin : coins) {
            int res = recurse(coins, amount - coin, dp);
            if (res != Integer.MAX_VALUE) {
                min = Math.min(min, 1 + res);
            }
        }

        return dp[amount] = min;
    }
}