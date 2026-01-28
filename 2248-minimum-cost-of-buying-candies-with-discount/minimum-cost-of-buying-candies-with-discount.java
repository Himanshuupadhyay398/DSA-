class Solution {
    public int minimumCost(int[] cost) {
        int n=cost.length;
        if(n==1) return cost[0];
        Arrays.sort(cost);
        int i=n-1;
        int min=0;
        while(i>=2){
            min+=cost[i]+cost[i-1];
            i-=3;
        }
         while (i >= 0) {
            min += cost[i];
            i--;
        }
    return min;
    }
}