class Solution {
    public String convert(String s, int numRows) {
        StringBuilder arr[]=new StringBuilder[numRows];
        for(int i=0;i<numRows;i++){
            arr[i]=new StringBuilder();
        }
        int i=0;
        while(i<s.length()){
            for(int j=0;j<numRows && i<s.length();j++){
                arr[j].append(s.charAt(i));
                i++;
            }
            for(int j=numRows-2;j>0 && i<s.length();j--){
                arr[j].append(s.charAt(i));
                i++;
            }
        }
        StringBuilder st=new StringBuilder();
        for(StringBuilder str:arr){
            st.append(str);
        }
    return st.toString();
    }
}