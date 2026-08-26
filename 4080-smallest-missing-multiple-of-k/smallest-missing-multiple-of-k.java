class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set=new HashSet<>();
        for(int i:nums){
            if(i%k==0)  set.add(i);
        }
        int max=0;
        for(int i=k;i<101;i+=k){
            if(!set.contains(i)){
                return i;
            }
            max=Math.max(max,i);
        }
    return max+k;
    }
}