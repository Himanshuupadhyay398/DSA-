class Solution {
    public int minOperations(int[] nums, int x) {
        int n=nums.length;
        int total=0;
        for(int i=0;i<n;i++){
            total+=nums[i];
        }
        int target=total-x;
        if(target==0) return n;
        if(target<0) return -1;

        int j=0,sum=0;
        int max=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];

            while(sum>target){
                sum-=nums[j];
                j++;
            }
            if(sum==target){
                max=Math.max(max,i-j+1);
            }
        }
    return max==0?-1:n-max;
    }
}