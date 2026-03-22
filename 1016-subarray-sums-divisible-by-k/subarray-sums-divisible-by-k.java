class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n=nums.length;
        int count=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        long prefix=0;
        for(int i=0;i<n;i++){
            prefix+=nums[i];
            int rem=(int)((prefix%k)+k)%k;  //for handling -ve numbers as remainder can exist form 0 to k....
            if(map.containsKey(rem)){
                count+=map.get(rem);
            }
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
    return count;
    }
}