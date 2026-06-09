class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int n=nums.length;
        if(nums.length==1){
            return 0;
        }
        Arrays.sort(nums);
        long diff=nums[n-1]-nums[0];
        long ans=diff*k;
        return ans;
    }
}