class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int n=nums2.length;
        int i=0;
        int max=0;
        for(int j=0;j<n;j++){
            while(i<nums1.length && nums1[i]>nums2[j]){
                i++;
            }
            if(i<=j && i<nums1.length){
                max=Math.max(max,j-i);
            }
        }
    return max;
    }
}