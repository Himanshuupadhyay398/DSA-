class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        long dp[][]=new long[n+1][2];
        for(int i=0;i<nums.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return recurse(0,nums,dp,true);
    }
    public long recurse(int index,int nums[],long dp[][],boolean visit){
        if(index>=nums.length) return 0;
        int flag=visit?1:0;
        if((dp[index][flag])!=-1) return dp[index][flag];
        long skip=recurse(index+1,nums,dp,visit);
        long value=nums[index];
        if(flag==0){
            value=-value;
        }
        long take=value+recurse(index+1,nums,dp,!visit);
    return dp[index][flag]=Math.max(take,skip);
    }
}