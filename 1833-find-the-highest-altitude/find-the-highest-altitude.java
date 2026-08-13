class Solution {
    public int largestAltitude(int[] gain) {
        int n=gain.length;
        int arr[]=new int [n+1];
        arr[0]=0;
        arr[1]=gain[0];
        int max=0;
        for(int i=1;i<n;i++){
            arr[i+1]=gain[i]+arr[i];
            max=Math.max(arr[i],max);
        }
        max=Math.max(arr[n],max);
    return max;
    }
}