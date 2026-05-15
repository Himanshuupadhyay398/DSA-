class Solution {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        long max=-1;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            max=Math.max(max,nums[i]);
            if(nums[i]>0){
                set.add(nums[i]);
            }
        }
        int ans=1;
        if(max<0){
            return ans;
        }
        for(int i=1;i<=max+1;i++){
            if(!set.contains(i)){
                ans=i;
                break;
            }
        }
    return ans;
    }
}