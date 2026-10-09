class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        HashSet<Character> set=new HashSet<>();
        int j=0,i=0;
        int max=0;
        while(i<n){
            char ch=s.charAt(i);
            if(set.contains(ch)){
                set.remove(s.charAt(j));
                j++;
            }else{
                set.add(ch);
                max=Math.max(max,i-j+1);
                i++;
            }
        }
    return max;
    }
}