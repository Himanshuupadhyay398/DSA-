class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n=nums.size();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            int val=nums.get(i);
            int ans=-1;
            for(int j=0;j<=val;j++){
                if((j | (j+1))==val){
                    ans=j;
                    break;
                }
            }
            arr[i]=ans;  
        }
    return arr;
    }
}