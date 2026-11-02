class Solution {
    public int minMoves2(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int mid=(0+n)/2;
        int moves=0;
        for(int i=0;i<n;i++){
            if(i<mid){
                moves+=nums[mid]-nums[i];
            }else{
                moves+=nums[i]-nums[mid];
            }
        }
    return moves;
    }
}