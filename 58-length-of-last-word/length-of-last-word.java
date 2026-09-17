class Solution {
    public int lengthOfLastWord(String s) {
        int n=s.length();
        int count=0;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)!=' '){
                count++;
            }if(s.charAt(i)!=' ' && i>0 && s.charAt(i-1)==' '){
                break;
            }
        }
    return count;
    }
}