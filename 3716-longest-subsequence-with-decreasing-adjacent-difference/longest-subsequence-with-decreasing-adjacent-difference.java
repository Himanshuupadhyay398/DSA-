class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int[][] dp=new int[303][303];
        int ans=0;
        for (int i=0;i<n;i++) {
            int max=0;
            for (int j =300;j>=0;j--) {
                int prevL=nums[i]-j;
                int prevG=nums[i]+j;
                int curr=0;
                if (prevL>=0) {
                    curr= Math.max(curr,1+dp[prevL][j]);
                }
                if (prevG<=300) {
                    curr=Math.max(curr,1+dp[prevG][j]);
                }
                max=Math.max(max,curr);
                dp[nums[i]][j]=max;
            }
            ans=Math.max(ans,max);
        }
        return ans;
    }
}
