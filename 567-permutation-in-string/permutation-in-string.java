class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        int freq[]=new int[26];
        for(char ch:s1.toCharArray()){
            freq[ch-'a']++;
        }
        int j=0;
        for(int i=0;i<m;i++){
            char ch=s2.charAt(i);
            freq[ch-'a']--;
            
            while(freq[ch-'a']<0){
                freq[s2.charAt(j)-'a']++;
                j++;
            }
            if(i-j+1==n) return true;
        }
    return false;
    }
}