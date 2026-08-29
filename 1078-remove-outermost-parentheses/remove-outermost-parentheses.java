class Solution {
    public String removeOuterParentheses(String s) {
        int n=s.length();
        StringBuilder st=new StringBuilder();
        int depth=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch==')'){
                depth--;
            }
            if(depth>0){
                st.append(ch);
            }
            if(ch=='('){
                depth++;
            }
        }
    return st.toString();
    }
}