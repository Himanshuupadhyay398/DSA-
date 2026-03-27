class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        int max=0,st=0;
        int dp[]=new int[n];
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(pali(dp,s,i,j)){
                    if(j-i+1>=max){
                        max=Math.max(j-i+1,max);
                        st=i;
                    }
                }
            }
        }
    return s.substring(st,st+max);
    }
    public boolean pali(int dp[],String s,int left,int right){
        while(left<=right){
            if(s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            }else{
                return false;
            }
        }
    return true;
    }
}