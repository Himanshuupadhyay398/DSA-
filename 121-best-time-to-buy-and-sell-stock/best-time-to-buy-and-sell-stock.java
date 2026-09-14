class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int i=0;
        int j=1;
        int maxdif=0;
        while(j<n){
            if(prices[i]<prices[j]){
                maxdif=Math.max(maxdif,prices[j]-prices[i]);
            }else{
                i=j;
            }
            j++;
        }
    return maxdif;
    }
}
