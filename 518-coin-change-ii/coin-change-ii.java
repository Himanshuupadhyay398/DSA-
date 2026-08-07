class Solution {
    public int change(int amount,int coins[]) {
    int n = coins.length;
        int dp[][]=new int[n][amount+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return recurse(amount,coins,0,dp);
    }
    public int recurse(int amount,int coins[],int index,int dp[][]){
        
        int n = coins.length;
        if(index==n){
            return amount==0?1:0;
        }

        if(dp[index][amount]!=-1) return dp[index][amount];
        int pick=0;
        if(coins[index]<=amount){
            pick=recurse(amount-coins[index],coins,index,dp);
        }
        int notpick=recurse(amount,coins,index+1,dp);
        return dp[index][amount]=pick+notpick;
    }
}