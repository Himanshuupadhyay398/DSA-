class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        allsubsets(0,result,new ArrayList<>(),nums);
        return result;
    }
    public void allsubsets(int i,List<List<Integer>> result,List<Integer> value,int[] nums){
        if(i>=nums.length){
            result.add(new ArrayList<>(value));
            return;
        }
        value.add(nums[i]);
        allsubsets(i+1,result,value,nums);
        value.remove(value.size()-1);
        allsubsets(i+1,result,value,nums);
    }
}