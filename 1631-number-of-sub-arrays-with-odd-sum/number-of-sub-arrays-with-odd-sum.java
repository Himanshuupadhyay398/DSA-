class Solution {
    public int numOfSubarrays(int[] arr) {
        int n=arr.length;
        int sum=0;
        long count=0;
        for(int i:arr){
            sum+=i;
            if(sum%2!=0){
                count++;
            }
            
        }
        count+=(n-count)*count;
    return (int)(count%1_000_000_007);
    }
}