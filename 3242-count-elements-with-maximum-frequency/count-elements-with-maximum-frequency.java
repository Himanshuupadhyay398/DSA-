class Solution {
    public int maxFrequencyElements(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int count=1;
        int ans=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(i<nums.length-1 && nums[i]==nums[i+1]){
                count++;
            }else{
                if(count>max){
                    max=count;
                    ans=count;
                }
                else if(count==max){
                    ans+=count;
                }
                count=1;
            }
        }
    return ans;
    }
}