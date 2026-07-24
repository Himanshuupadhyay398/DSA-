class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n=nums.length;

        if(n<=2) return n;

        int bitmask=0;
        for(int num:nums){
            bitmask |=num;
        }
    return bitmask+1;
    }
}