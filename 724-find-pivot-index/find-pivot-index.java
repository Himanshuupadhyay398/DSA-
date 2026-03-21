class Solution {
    public int pivotIndex(int[] nums) {
        int n=nums.length;
        int temp[]=new int[n];
        temp[0]=nums[0];
        for(int i=1;i<n;i++){
            temp[i]=temp[i-1]+nums[i];
        }
        
        for(int i=0;i<n;i++){
            int leftsum=0;
            int rightsum=0;
            if(i>0) leftsum=temp[i-1];
            rightsum=temp[n-1]-temp[i];
            
            if(leftsum==rightsum) return i;
        }
    return -1;
    }
}