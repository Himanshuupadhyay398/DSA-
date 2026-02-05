class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n=nums.length;
        int result[]=new int[n];
        int i=0,j=0;
        while(i<n){
            int val=(i+nums[i])%n;
            if(val<0) val+=n;
            result[j]=nums[val];
            i++;
            j++;
        }
    return result;
    }
}