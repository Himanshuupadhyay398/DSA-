class Solution {
    public String digitSum(String s, int k) {
        int n=s.length();
        StringBuilder sb=new StringBuilder();
        sb.append(s);
        while(sb.length()>k){
            int sum=0;
            StringBuilder st=new StringBuilder();
            for(int i=0;i<sb.length();i++){
                int val=sb.charAt(i)-'0';
                sum+=val;
                if(i%k==k-1 || i==sb.length()-1){
                    st.append(sum);
                    sum=0;
                }
            }
        sb.delete(0,sb.length());
        sb.append(st);
        }
    return sb.toString();
    }
}