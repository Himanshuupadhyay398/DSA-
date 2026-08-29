class Solution {
    public String reverseWords(String s) {

        StringBuilder st=new StringBuilder();
        String str=s.trim();
        int j=str.length();
        for(int i=str.length()-1;i>=0;i--){
            char ch=str.charAt(i);
            if(ch==' '){
                if(i+1<j){
                    st.append(str.substring(i+1,j));
                    st.append(' ');
                }
                j=i;
            }
            if(i==0 && i<j){
                st.append(str.substring(i,j));   
            }
        }
    return st.toString();
    }
}