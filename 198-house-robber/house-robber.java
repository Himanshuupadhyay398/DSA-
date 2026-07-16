class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return recurse(nums,0,dp);
    }
    public int recurse(int nums[],int index,int dp[]){
        int n=nums.length;
        if(index>=n){
            return 0;
        }
        if(dp[index]!=-1) return dp[index];

        int step1=nums[index]+recurse(nums,index+2,dp);
        int step2=recurse(nums,index+1,dp);

        return dp[index]=Math.max(step1,step2);
    }
}