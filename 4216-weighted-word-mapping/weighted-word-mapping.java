class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        int n=words.length;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=0;j<words[i].length();j++){
                sum+=weights[words[i].charAt(j)-'a'];
            }
            int val=sum%26;
            int index=Math.abs(val-25);
            sb.append((char)(index+'a'));

            
        }
    return sb.toString();
    }
}