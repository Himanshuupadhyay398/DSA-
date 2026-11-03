class Solution {
    public int minMoves(int[] nums) {
        int n=nums.length;
        int max=0;
        for(int num:nums){
            max=Math.max(max,num);
        }

        int result=0;
        for(int i:nums){
            result+=max-i;
        }
    return result;
    
    }
}