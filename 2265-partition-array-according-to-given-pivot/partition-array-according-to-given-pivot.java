class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int idx =0;
        int[] res = new int[n];
        for(int num : nums){
            if(num < pivot){
                res[idx++] = num;
            }
        }
        for(int num : nums){
            if(num == pivot){
                res[idx++] = num;
            }
        }
        for(int num : nums){
            if(num > pivot){
                res[idx++] = num;
            }
        }
        return res;

    } 
}