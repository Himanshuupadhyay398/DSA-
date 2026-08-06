class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n=nums.length;
        List<Integer> result=new ArrayList<>();
        Arrays.sort(nums);
        int start=nums[0];
        for(int i=0;i<n;i++){
            while(nums[i]!=start){
                result.add(start);
                start++;
            }
            start++;
        }
    return result;
    }
}