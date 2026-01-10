class Solution {
    //memoization
    // public int rob(int[] nums) {
    //     int n=nums.length;
    //     int dp[]=new int[n+1];
    //     Arrays.fill(dp,-1);
    //     return houseRob(0,nums,dp);
    // }           
    // public int houseRob(int index,int nums[],int[]dp){
    //     if(index>=nums.length){
    //         return 0;
    //     }
    //     if(dp[index]!=-1) return dp[index];

    //     int pick=nums[index]+houseRob(index+2,nums,dp);
    //     int notpick=houseRob(index+1,nums,dp);
    //     return dp[index]=Math.max(pick,notpick);
    // }       
    public int rob(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n+1];
        dp[0]=0;
        dp[1]=nums[0];
        for(int i=2;i<=n;i++){
            dp[i]=Math.max(dp[i-1],nums[i-1]+dp[i-2]);
        }
    return dp[n];
    }
} 