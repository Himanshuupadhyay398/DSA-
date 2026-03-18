class Solution {
    int dp[]=new int[101];
    public int rob(int[] nums) {
        Arrays.fill(dp,-1);
        return recurse(nums,0);
    }
    public int recurse(int nums[],int idx){
        int n=nums.length;
        if(idx>=n){
            return 0;
        }
        if(dp[idx]!=-1) return dp[idx];
        int pick=nums[idx]+recurse(nums,idx+2);
        int notake=recurse(nums,idx+1);
        return dp[idx]=Math.max(pick,notake);
    }
}