class Solution {
    public int countBinarySubstrings(String s) {
        int n=s.length();
        int left=0,present=1,min=0;
        for(int i=1;i<n;i++){
            if(s.charAt(i)==s.charAt(i-1)){
                present++;
            }else{
                min+=Math.min(left,present);
                left=present;
                present=1;
            }
        }
    min+=Math.min(left,present);
    return min;
    }
}