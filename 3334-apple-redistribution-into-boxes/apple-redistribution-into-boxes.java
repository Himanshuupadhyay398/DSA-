class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int n=apple.length;
        Arrays.sort(capacity);
        int val=0,maxVal=0,count=0;
        for(int i=0;i<n;i++){
            val+=apple[i];
        }
        for(int i=capacity.length-1;i>=0;i--){
            if(maxVal>=val){
                break;
            }
            maxVal+=capacity[i];
            count++;
        }
    return count;
    }
}