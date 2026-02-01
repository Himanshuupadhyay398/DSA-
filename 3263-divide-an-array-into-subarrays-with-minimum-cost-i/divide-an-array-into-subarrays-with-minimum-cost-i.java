class Solution {
    public int minimumCost(int[] nums) {
        int n=nums.length;
        int number=nums[0];
        Arrays.sort(nums);
        if(number==nums[0]){
            number+=nums[1]+nums[2];
        }else if(number==nums[1]){
            number+=nums[0]+nums[2];
        }else{
            number+=nums[0]+nums[1];
        }
    return number;
    }
}