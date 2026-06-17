class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(candidates);
        sumtwo(0,result,candidates,target,new ArrayList<>());
        return result;
    }
    public void sumtwo(int i,List<List<Integer>> result,int[] candidates,int target,List<Integer> ans){
        if(target==0){
            result.add(new ArrayList<>(ans));
            return;
        }
        if(target<0){
            return;
        }
        for(int j=i;j<candidates.length;j++){
            if(j>i && candidates[j]==candidates[j-1]) continue;
            ans.add(candidates[j]);
            sumtwo(j+1,result,candidates,target-candidates[j],ans);
            ans.remove(ans.size()-1);
        }
    }
}