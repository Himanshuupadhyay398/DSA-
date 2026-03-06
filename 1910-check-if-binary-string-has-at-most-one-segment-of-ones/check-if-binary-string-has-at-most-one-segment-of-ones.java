class Solution {
    public boolean checkOnesSegment(String s) {
        for(int i=1;i<s.length();i++){
            char ch=s.charAt(i);
            char ch1=s.charAt(i-1);
            if(ch=='1' && ch1=='0'){
                return false;
            }
        }
    return true;
    }
}