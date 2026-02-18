class Solution {
    public boolean hasAlternatingBits(int n) {
        String st="";
        while(n>0){
            st+=n%2;
            n=n/2;
        }
        for(int i=st.length()-1;i>0;i--){
            if(st.charAt(i)=='1'){
                if(st.charAt(i-1)!='0'){
                    return false;
                }
            }else if(st.charAt(i)=='0'){
                if(st.charAt(i-1)!='1'){
                    return false;
                }
            }
        }
    return true;
    }
}