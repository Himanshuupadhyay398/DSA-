class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int dp[]=new int[n];
        int prevIdx[]=new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(prevIdx,-1);

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0 && dp[j] + 1 > dp[i]){
                    dp[i]=dp[j]+1;
                    prevIdx[i]=j;
                }
            }
        }
        int maxLen=1;
        int index=0;
        for(int i=0;i<n;i++){
            if(dp[i]>maxLen){
                maxLen=dp[i];
                index=i;
            }
        }
        List<Integer> result=new ArrayList<>();
        while(index>=0){
            result.add(nums[index]);
            index=prevIdx[index];
        }
    return result;
    }
}