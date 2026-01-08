
class Solution {
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n][n + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(0, -1, nums);
    }

    private int solve(int i, int prevIndex, int[] nums) {
        if (i == nums.length) return 0;
        if (dp[i][prevIndex + 1] != -1) return dp[i][prevIndex + 1];
        int notTake = solve(i + 1, prevIndex, nums);
        int take = 0;
        if (prevIndex == -1 || nums[i] > nums[prevIndex]) {
            take = 1 + solve(i + 1, i, nums);
        }
        return dp[i][prevIndex + 1] = Math.max(take, notTake);
    }
}
