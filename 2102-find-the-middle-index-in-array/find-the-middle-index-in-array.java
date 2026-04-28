// class Solution {
//     public int findMiddleIndex(int[] nums) {
//         int n=nums.length;
//         int  prefix[]=new int[n];
//         int suffix[]=new int[n];
//         prefix[0]=nums[0];
//         for(int i=1;i<n;i++){
//             prefix[i]=nums[i]+prefix[i-1];
//         }
//         suffix[n-1]=nums[n-1];
//         for(int i=n-2;i>=0;i--){
//             suffix[i]=suffix[i+1]+nums[i];
//         }
//         for(int i=0;i<n;i++){
//             int left=(i>0)?prefix[i-1]:0;
//             int right=(i<nums.length-1)?suffix[i+1]:0;

//             if(left==right){
//                 return i;
//             }
//         }
//     return -1;
//     }
// } 


class Solution {
    public int findMiddleIndex(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        int t = 0;
        for(int i:nums){
            t+=i;
        }
        int left =0;
        for(int i=0;i<nums.length;i++){
            int right = t - nums[i] - left;
            if(right==left){
                return i;
            }
            left +=nums[i];
        }
    return -1;
    }
}