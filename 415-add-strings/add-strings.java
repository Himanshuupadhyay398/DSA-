class Solution {
    public String addStrings(String num1, String num2) {
        int n=num1.length()-1;
        int m=num2.length()-1;
        StringBuilder st=new StringBuilder();
        int i=n,j=m,carry=0;
        while(i>=0 || j>=0 ||carry!=0){
            int D1= i>=0 ?num1.charAt(i)-'0':0;
            int D2= j>=0 ?num2.charAt(j)-'0':0;
            int sum=D1+D2+carry;
            carry=sum/10;
            st.append(sum%10);
            i--;
            j--;
        }
    return st.reverse().toString();
    }
}