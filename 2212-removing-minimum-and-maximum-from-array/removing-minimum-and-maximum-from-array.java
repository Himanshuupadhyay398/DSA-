class Solution {
    public int minimumDeletions(int[] nums) {

        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int indexmin = 0, indexmax = 0;

        for (int i = 0; i < n; i++) {
            if (min > nums[i]) {
                min = nums[i];
                indexmin = i;
            }
            if (max < nums[i]) {
                max = nums[i];
                indexmax = i;
            }
        }
        if(indexmin>indexmax){
            int temp=indexmin;
            indexmin=indexmax;
            indexmax=temp;
        }

        int left=n-indexmin;
        int right=indexmax+1;
        int both=(indexmin+1)+(n-indexmax);

        return Math.min(both,Math.min(left,right));
    }
}