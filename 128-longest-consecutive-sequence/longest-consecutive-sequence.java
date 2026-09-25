class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        HashSet<Integer> hash=new HashSet<>();
        int max=0;
        for(int i=0;i<n;i++){
                hash.add(nums[i]);
        }
        for(int num:hash){
            int count=1;
            int m=num;
            if(!hash.contains(m-1)){
                
                while(hash.contains(m+1)){
                    count++;
                    m++;
                }
                
            }
            
            max=Math.max(max,count);
        }
    return max;
    }
}