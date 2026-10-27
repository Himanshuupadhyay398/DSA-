class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        boolean flag=true;
        StringBuilder st=new StringBuilder();
        int i=0,j=0;
        while(i<n && j<m){
            if(flag){
                st.append(word1.charAt(i));
                i++;
                flag=false;
            }else{
                st.append(word2.charAt(j));
                j++;
                flag=true;
            }
        }
        while(i<n){
            st.append(word1.charAt(i));
            i++;
        }
        while(j<m){
            st.append(word2.charAt(j));
            j++;
        }
    return st.toString();
    }
}