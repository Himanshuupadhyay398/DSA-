class Solution {
    public int lengthOfLIS(int[] nums) {

        //bottom up 

        int n = nums.length;
    //     int []dp=new int[n];
    //     Arrays.fill(dp,1);
    //     int max=1;
    //     for(int i=1;i<n;i++){
    //         for(int j=0;j<i;j++){
    //             if(nums[i]>nums[j]){
    //                 dp[i]=Math.max(dp[i],dp[j]+1);
    //             }
    //         }
    //         max=Math.max(dp[i],max);
    //     }
    // return max;
    // }
    
    //memoization

        int [][]dp = new int[n+1][n+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],1);
        }
        
        return recurse(0,nums,dp,-1);
    }
    public int recurse(int i,int nums[],int dp[][],int prev){
        if(i>=nums.length) return 0;
        if(dp[i][prev+1]!=1) return dp[i][prev+1];
        int take=0;
        if(prev==-1 || nums[i]>nums[prev]){
            take=1+recurse(i+1,nums,dp,i);
        }
        int skip=recurse(i+1,nums,dp,prev);
        return dp[i][prev+1]=Math.max(take,skip);
    }
}
