class Solution {
    public int minRemoval(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        int j=0,len=0;
        for(int i=0;i<n;i++){
            while(nums[i]>(long)nums[j]*k){
                j++;
            }
            len=Math.max(len,i-j+1);
        }
    return n-len;
    }
}