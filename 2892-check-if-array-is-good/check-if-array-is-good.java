class Solution {
    public boolean isGood(int[] nums) {
        int n=nums.length;
        int max=0;
        int count=0;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            max=Math.max(max,nums[i]);
            set.add(nums[i]);
        }
        for(int i=0;i<n;i++){
            if(nums[i]==max){
                count++;
            }
        }
        
        if(count!=2) return false;
       if(max+1>n || n>max+1) return false;
       for(int i=1;i<=max;i++){

            if(!set.contains(i) ){
                return false;
            }
       }
    return true;
    }
}