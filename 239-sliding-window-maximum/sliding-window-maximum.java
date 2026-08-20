class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int result[]=new int[n-k+1];
        Deque<Integer> dq=new LinkedList<>();

        int i=0;
        for(int j=0;j<n;j++){

            while(!dq.isEmpty() && dq.peekFirst()<=j-k){
                dq.removeFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[j]){
                dq.removeLast();
            }

            dq.addLast(j);
            if(j-i+1==k){
                result[i]=nums[dq.peekFirst()];
                i++;
            }
        }
    return result;
    }
}