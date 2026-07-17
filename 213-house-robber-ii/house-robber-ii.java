class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int dp1[]=new int[n];
        Arrays.fill(dp1,-1);
        int val=recurse(0,nums,n-2,dp1);
        int dp2[]=new int[n];
        Arrays.fill(dp2,-1);
        int val2=recurse(1,nums,n-1,dp2);
        return Math.max(val,val2);
    }

    public int recurse(int index,int nums[],int end,int dp[]){
        if(index>end){
            return 0;
        }
        if(dp[index]!=-1) return  dp[index];
        int rob=nums[index]+recurse(index+2,nums,end,dp);
        int skip=recurse(index+1,nums,end,dp);
        return dp[index]=Math.max(rob,skip);
    }
}