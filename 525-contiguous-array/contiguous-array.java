class Solution {
    public int findMaxLength(int[] nums) {
        int n=nums.length;

        int len=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int curr=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                curr--;
            }else{
                curr++;
            }
            if(map.containsKey(curr)){
                len=Math.max(len,i-map.get(curr));
            }
            map.putIfAbsent(curr,i);
        }
    return len;
    }
}