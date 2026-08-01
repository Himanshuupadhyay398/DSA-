class Solution {
    public boolean predictTheWinner(int[] nums) {
       int n=nums.length;

       if((n&1)==0) return true;

       int dp[][]=new int[n][n];

       for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
       }

       return recurse(0,n-1,nums,dp)>=0;
    }
    public int recurse(int i,int j ,int nums[],int dp[][]){
        if(dp[i][j]!=-1) return dp[i][j];
        if(i==j) return dp[i][j]=nums[i];

        return dp[i][j]=Math.max(nums[i]-recurse(i+1,j,nums,dp),nums[j]-recurse(i,j-1,nums,dp));
    }
}