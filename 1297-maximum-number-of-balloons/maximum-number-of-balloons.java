class Solution {
    public int maxNumberOfBalloons(String text) {
        String s="balon";
        if(text.length()<s.length()) return 0;
        int frq[]=new int[26];
        for(int i=0;i<text.length();i++){
            frq[text.charAt(i)-'a']++;
        }
        frq['l'-'a'] /=2;
        frq['o'-'a'] /=2;

        int instance=Integer.MAX_VALUE;
        for(int i=0;i<s.length();i++){
            instance = Math.min(instance,frq[s.charAt(i)-'a']);
        }
    return instance;
    }
}