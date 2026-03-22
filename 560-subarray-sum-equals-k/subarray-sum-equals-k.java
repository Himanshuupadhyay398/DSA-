class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        int count=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int prefix=0;
        for(int i=0;i<n;i++){
            prefix+=nums[i];
            if(map.containsKey(prefix-k)){
                count+=map.get(prefix-k);
            }
            map.put(prefix,map.getOrDefault(prefix,0)+1);
        }
    return count;
    }
}