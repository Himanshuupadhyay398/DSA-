class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;

        if(k>n || k<0) return -1;
        int i,j=n-1;
        int sum=0;
        int max=0;
        for(i=0;i<k;i++){
            sum+=cardPoints[i];
        }
        max=Math.max(sum,max);
        while(i>0 && i<n){
            sum-=cardPoints[i-1];
            sum+=cardPoints[j];
            i--;
            j--;
            max=Math.max(sum,max);
        }
    return max;
    }
}