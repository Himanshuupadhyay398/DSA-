class Solution {
    public int hIndex(int[] citations) {
        int n=citations.length;

        Arrays.sort(citations);
        int h_index=0;
        for(int i=0;i<n;i++){
            int val=n-i;
            if(citations[i]>=val){
                return val;
            }
        }
    return 0;
    }
}