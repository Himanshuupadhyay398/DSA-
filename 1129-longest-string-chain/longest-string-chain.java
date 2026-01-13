class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b)->a.length()-b.length());
        int n=words.length;
        int dp[]=new int[n];
        Arrays.fill(dp,1);
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(predessors(words[j],words[i])){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        ans=Math.max(ans,dp[i]);
        }
    return ans;
    }
    public boolean predessors(String one,String two){
        if(two.length()!=one.length()+1) return false;
        boolean rep=false;
        int i=0,j=0;
        while(i<one.length() && j<two.length()){
            if(one.charAt(i)==two.charAt(j)){
                i++;
                j++;
            }else{
                if(rep) return false;
                rep=true;
                j++;
            }
        }
    return true;
    }
}