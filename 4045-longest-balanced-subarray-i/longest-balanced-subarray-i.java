class Solution {
    public int longestBalanced(int[] nums) {
        int max = 0;
        for(int i=0;i<nums.length;i++){
        int cnto=0,cnte=0;
            HashSet<Integer>st = new HashSet<>(); 
            for(int j=i;j<nums.length;j++){
                if(nums[j]%2!=0){
                    if(!st.contains(nums[j])){
                        st.add(nums[j]);
                        cnto++;
                    }
                }else{
                    if(!st.contains(nums[j])){
                        st.add(nums[j]);
                        cnte++;
                    }
                }
                if(cnto==cnte){
                    max =Math.max(max,(j-i+1));
                }
            }
        }
        return max;
    }
}