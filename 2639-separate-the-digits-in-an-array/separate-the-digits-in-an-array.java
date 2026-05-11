class Solution {
    public int[] separateDigits(int[] nums) {
        int n=nums.length;
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            ArrayList<Integer> lst=new ArrayList<>();
            int num=nums[i];
            while(num>0){
                int rem=num%10;
                lst.add(rem);
                num=num/10;
            }

            ans.addAll(lst.reversed());
        }
        int result[]=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            result[i]=ans.get(i);
        }
    return result;
    }
}