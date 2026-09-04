class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        int maxi[]=new int[n];
        int mini[]=new int[n];
        int max=0,min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){

            max=Math.max(max,nums[i]);
            maxi[i]=max;
        }
        for(int i=n-1;i>=0;i--){
            min=Math.min(min,nums[i]);
            mini[i]=min;
        }
        
        for(int i=0;i<n;i++){
            if(maxi[i]-mini[i]<=k){
                return i;
            }
        }
    return -1;
    }
}