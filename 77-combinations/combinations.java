class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result=new ArrayList<>();
        recurse(1,result,n,k,new ArrayList<>());
        return result;
    }
    public void recurse(int i,List<List<Integer>> result,int n,int k,ArrayList<Integer>al){
        if(al.size()==k){
            result.add(new ArrayList<>(al));
            return;
        }
        if(i>n){
            return;
        }
        al.add(i);
        recurse(i+1,result,n,k,al);
        al.remove(al.size()-1);

        recurse(i+1,result,n,k,al);
    }
}