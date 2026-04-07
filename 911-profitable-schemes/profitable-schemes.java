class Solution {
    Integer dp[][][];
    int N;
    int mod=(int)1e9+7;

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        dp = new Integer[101][101][101];
        int m = group.length;
        N = n;
        return solve(0, 0, 0, minProfit, group, profit);
    }

    public int solve(int index, int people, int P, int minPro, int group[], int profit[]) {
        if (people > N)
            return 0;

        if(index==group.length){
            if (P >= minPro) {
                return 1;
            } else {
                return 0;
            }
        }
        if (dp[index][people][P] != null)
            return dp[index][people][P];

        int notake = solve(index + 1, people, P, minPro, group, profit)%mod;
        int take = solve(index + 1, people + group[index], Math.min(profit[index] + P,minPro), minPro, group, profit)%mod;

        return dp[index][people][P] = (take + notake)%mod;
    }
}