class Solution {
    public int minRemoval(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        int j=0,len=0,i=0;
        while(j<n){
            if(nums[j]<=(long)nums[i]*k){
                len=Math.max(len,j-i+1);
                j++;
            }else{
                i++;
            }
        }
    return n-len;
    }
}