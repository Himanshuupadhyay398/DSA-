class Solution {
    public int maxRotateFunction(int[] nums) {
        int n=nums.length;
        int sum=0;
        int func0=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            func0+=nums[i]*i;

        }

        int max=func0;
        int curr=func0;
        for(int k=1;k<n;k++){
            curr=curr+sum-(n*nums[n-k]);
            max=Math.max(curr,max);
        }
    return max;
    }
}