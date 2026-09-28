class Solution {
    public String reverseParentheses(String s) {
        int n=s.length();
        Stack<Integer> stack=new Stack<>();
        StringBuilder st=new StringBuilder();
        for(int i=0;i<n;i++){
            if(s.charAt(i)!='(' && s.charAt(i)!=')'){
                st.append(s.charAt(i));
                continue;
            }
            if(s.charAt(i)=='('){
                stack.push(st.length());
            }else if(s.charAt(i)==')'){
                int left=stack.pop();
                reverse(st,left);
            }
        }
    return st.toString();
    }
    public void reverse(StringBuilder st,int begin){

        int i=st.length()-1;

        while(begin<i){
            char temp = st.charAt(begin);
            st.setCharAt(begin, st.charAt(i));
            st.setCharAt(i, temp);
            begin++;
            i--;
        }
    }
}