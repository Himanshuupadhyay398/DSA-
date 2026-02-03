class Solution {
    public boolean isTrionic(int[] nums) {
        int n=nums.length;
        int i=0;
        while (i+1<n && nums[i]<nums[i+1]) {
            i++;
        }

        if(i==n-1 || i==0) return false;

        while(i+1<n && nums[i]>nums[i+1]){
            i++;
        }

        if(i==n-1 || i==0) return false;

        while(i+1<n){
            if(nums[i]>=nums[i+1]) return false;
            i++;
        }
    return true;

    }
}