class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n=nums.length;
        long total=0;
        HashSet<Integer> set=new HashSet<>();
        int i=0,j=0;
        long sum=0;
        while(j<n){
            while(set.contains(nums[j])){
                sum-=nums[i];
                set.remove(nums[i]);
                i++;
            }
            sum+=nums[j];
            set.add(nums[j]);
            if(j-i+1>k){
                sum-=nums[i];
                set.remove(nums[i]);
                i++;
            }
            if(j-i+1==k){
                total=Math.max(total,sum);
            }
            j++;
        }
    return total;
    }
}