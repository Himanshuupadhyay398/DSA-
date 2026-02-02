class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        int dp[][]=new int[n][(sum/2)+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return recurse(dp,nums,n-1,sum/2);
    }
    public boolean recurse(int dp[][],int nums[],int index,int target){
        if (target == 0) return true;
        if (index < 0 || target < 0) return false;

        if (dp[index][target]!=-1) {
            return dp[index][target]==1;
        }

        boolean take= recurse(dp, nums, index - 1, target - nums[index]);
        boolean notTake=recurse(dp, nums, index - 1, target);

        dp[index][target] = (take || notTake) ? 1 : 0;
        return dp[index][target] == 1;
    }
}