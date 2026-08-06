class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        return recurse(nums,target,0,0);
    }
    public int recurse(int nums[],int target,int index,int sum){
        int n=nums.length;
        if(index==n){
            return sum==target?1:0;
        }
        int add=recurse(nums,target,index+1,sum+nums[index]);
        int sub=recurse(nums,target,index+1,sum-nums[index]);

        return add+sub;
    }
}