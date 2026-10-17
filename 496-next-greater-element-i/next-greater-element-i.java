class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int n1=nums2.length;

        Stack<Integer> stack=new Stack<>();
        int arr[]=new int[10000];
        for(int i=n1-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<nums2[i]){
                stack.pop();
            }
            arr[nums2[i]]=stack.isEmpty()?-1:stack.peek();
            stack.push(nums2[i]);
        }
    for(int i=0;i<n;i++){
        nums1[i]=arr[nums1[i]];
    }
    return nums1;
    }
}