class Solution {
    public boolean checkString(String s) {
        boolean checkA=false;
        boolean checkB=false;
        for(int i=0;i<s.length();i++){
            if(!checkA && s.charAt(i)=='a'){
                checkA=true;
            }
            if(!checkB && s.charAt(i)=='b'){
                checkB=true;
            }
            if(s.charAt(i)=='a' && checkB){
                return false;
            }
        }
    return true;
    }
}