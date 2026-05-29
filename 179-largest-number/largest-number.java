class Solution {
    public String largestNumber(int[] nums) {
        int n=nums.length;
        String concate[]=new String[n];
        for(int i=0;i<n;i++){
            concate[i]=String.valueOf(nums[i]);
        }

        Arrays.sort(concate,(a,b)->(b+a).compareTo(a+b));

        if(concate[0].equals("0")) return "0";
        StringBuilder str=new StringBuilder();
        for(String st:concate){
            str.append(st);
        }

    return str.toString();
    }
}