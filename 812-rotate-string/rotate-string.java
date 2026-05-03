class Solution {
    public boolean rotateString(String s, String goal) {
        String str=s+s;
        if(goal.length()!=s.length()){
            return false;
        }
    return str.contains(goal);
    }
}