class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int i=0,j=0;
        int sum=0;
        int minlen=Integer.MAX_VALUE;
        while(i<n && j<n){
            sum+=nums[j];
            while(sum>=target){
                minlen=Math.min(minlen,j-i+1);
                sum-=nums[i];
                i++;
            }
            j++;
        }
        if(minlen==Integer.MAX_VALUE){
            return 0;
        }
    return minlen;
    }
}