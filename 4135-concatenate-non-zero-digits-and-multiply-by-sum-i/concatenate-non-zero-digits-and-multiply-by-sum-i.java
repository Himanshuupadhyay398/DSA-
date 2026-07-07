class Solution {
    public long sumAndMultiply(int n) {
        String str=Integer.toString(n);
        long val=0;
        long mul=0;
        for(int i=0;i<str.length();i++){
            if((str.charAt(i)-'0')!=0){
                val=val*10+(str.charAt(i)-'0');
                mul+=str.charAt(i)-'0';
            }
        }
    return val*mul;
    }
}