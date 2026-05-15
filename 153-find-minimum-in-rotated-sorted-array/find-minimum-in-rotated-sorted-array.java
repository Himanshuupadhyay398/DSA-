class Solution {
    public int findMin(int[] nums) {
        int min=Integer.MAX_VALUE;
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            min=Math.min(min,nums[high]);
            high--;
        }
    return min;
    }
}