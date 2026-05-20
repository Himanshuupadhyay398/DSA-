class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        int offset=10000;
       
        int arr[]=new int[20001];
        
        for(int i=0;i<n;i++){
            arr[nums[i]+offset]++;
        }

        for(int i=20000;i>=0;i--){
            if(k-arr[i]>0){
                k-=arr[i];
            }else{
                return i-offset;
            }
        }
    return 0;
    }
}