class Solution {
    public int lengthOfLIS(int[] nums) {

        //bottom up 

        int n = nums.length;
        int []dp=new int[n];
        Arrays.fill(dp,1);
        int max=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            max=Math.max(dp[i],max);
        }
    return max;
    }
    
    //memoization

    //     dp = new int[n][n + 1];
    //     for (int i = 0; i < n; i++) {
    //         Arrays.fill(dp[i], -1);
    //     }
    //     dp[n][n+1]=0;
    // }

    // private int solve(int i, int prevIndex, int[] nums) {
    //     if (i == nums.length) return 0;
    //     if (dp[i][prevIndex + 1] != -1) return dp[i][prevIndex + 1];
    //     int notTake = solve(i + 1, prevIndex, nums);
    //     int take = 0;
    //     if (prevIndex == -1 || nums[i] > nums[prevIndex]) {
    //         take = 1 + solve(i + 1, i, nums);
    //     }
    //     return dp[i][prevIndex + 1] = Math.max(take, notTake);
    // }
}
