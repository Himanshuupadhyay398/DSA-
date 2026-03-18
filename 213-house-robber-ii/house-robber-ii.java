class Solution {
    public int rob(int[] nums) {
        int n=nums.length;

        if(n==1) return nums[0];
        int dp1[]=new int[n+1];
        Arrays.fill(dp1,-1);
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        int max=recurse(nums,dp,0,n-2);
        int max1=recurse(nums,dp1,1,n-1);
        return Math.max(max,max1);
    }
    public int recurse(int nums[],int dp[],int idx,int end){
        int n=nums.length;
        if(idx>end){
            return 0;
        }
        if(dp[idx]!=-1) return dp[idx];
        int take=nums[idx]+recurse(nums,dp,idx+2,end);
        int notake=recurse(nums,dp,idx+1,end);
        return dp[idx]=Math.max(take,notake);
    }
}