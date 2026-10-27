class Solution {
    public String reverseWords(String s) {
        ArrayList<String> lst=new ArrayList<>();
        int j=-1;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch==' '){
                String rev=reverse(s.substring(j+1,i));
                lst.add(rev);
                j=i;
            }
        }
        String rev=reverse(s.substring(j+1,s.length()));
        lst.add(rev);

        StringBuilder st=new StringBuilder();
        for(int i=0;i<lst.size();i++){
            st.append(lst.get(i));
            st.append(' ');
        }
       st.deleteCharAt(st.length() - 1);
    return st.toString();
    }

    public String reverse(String original){
        StringBuilder sb = new StringBuilder();
        for (int i = original.length() - 1; i >= 0; i--) {
            sb.append(original.charAt(i));
        }
        String reversed = sb.toString();
    return reversed;
    }
}