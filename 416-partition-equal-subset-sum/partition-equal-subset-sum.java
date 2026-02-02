class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        int target=sum/2;
        int m=(sum/2)+1;
        int dp[][]=new int[n][m];
    //     for(int i=0;i<n;i++){
    //         Arrays.fill(dp[i],-1);
    //     }
    //     return recurse(dp,nums,n-1,sum/2);
    // }
    // public boolean recurse(int dp[][],int nums[],int index,int target){
    //     if (target == 0) return true;
    //     if (index < 0 || target < 0) return false;

    //     if (dp[index][target]!=-1) {
    //         return dp[index][target]==1;
    //     }

    //     boolean take= recurse(dp, nums, index - 1, target - nums[index]);
    //     boolean notTake=recurse(dp, nums, index - 1, target);

    //     dp[index][target] = (take || notTake) ? 1 : 0;
    //     return dp[index][target] == 1;

    //tabulation

        for(int i=0;i<n;i++){                    // if (target == 0) return true;
            dp[i][0]=1;
        }
        
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                int noTake=dp[i-1][j];          //recurse(dp, nums, index - 1, target);
                int take = 0;
                if(nums[i]<=j){                 //recurse(dp, nums, index - 1, target-nums[index]);
                    take=dp[i-1][j-nums[i]];
                }
                dp[i][j]=(take==1 || noTake==1)?1:0;
            }
            
        }
        return dp[n-1][target]==1;
    }
}