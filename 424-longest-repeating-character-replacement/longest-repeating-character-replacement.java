class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int freq[]=new int[26];

        int j=0;
        int maxlen=0,maxfreq=0;
        for(int i=0;i<n;i++){
            freq[s.charAt(i)-'A']++;
            maxfreq=Math.max(maxfreq,freq[s.charAt(i)-'A']);
            if((i-j+1)-maxfreq<=k){
                maxlen=Math.max(maxlen,i-j+1);
            }else{
                freq[s.charAt(j)-'A']--;
                j++;
                maxfreq=0;
            }
        }
    return maxlen;
    }
}