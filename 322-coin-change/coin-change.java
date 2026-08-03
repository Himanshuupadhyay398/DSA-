class Solution {
    static final int INF = (int)1e9;
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int dp[][]=new int[n][amount+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        
        int ans= recurse(0,coins,amount,dp);
        return ans==INF?-1:ans; 
    }
    public int recurse(int index,int coins[],int amount,int dp[][]){
        int n=coins.length;

        if(index>=n){
            return amount==0?0:INF;
        }

        if(dp[index][amount]!=-1) return dp[index][amount];

        int pick=INF;
        if(amount-coins[index]>=0){
            pick=1+recurse(index,coins,amount-coins[index],dp);
        }

        int nopick=recurse(index+1,coins,amount,dp);

        return dp[index][amount]=Math.min(pick,nopick);
    }
}















