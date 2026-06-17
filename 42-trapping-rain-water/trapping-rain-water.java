class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int total=0,leftmax=0,rightmax=0;
        int l=0,r=n-1;
        while(l<r){

            leftmax=Math.max(leftmax,height[l]);
            rightmax=Math.max(rightmax,height[r]);
            if(height[l]<=height[r]){
                total+=leftmax-height[l];
                l++;
            }else{
                total+=rightmax-height[r];
                r--;
            }
        }
    return total;
    }
}




//

// 