class Solution {
    public int longestStrChain(String[] words) {

    // memoization
        int n=words.length;
        Arrays.sort(words,(a,b)->a.length()-b.length());
        int dp[][]=new int[n+1][n+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return recurse(words,dp,0,-1);
    }
    public int recurse(String words[],int dp[][],int index,int p){
        if(index>=words.length) return 0;
        if(dp[index][p+1]!=-1) return dp[index][p+1];

        int take=0;
        if(p==-1 || isPred(words[p],words[index])){
            take=1+recurse(words,dp,index+1,index);
        }
        int skip=recurse(words,dp,index+1,p);
        return dp[index][p+1]=Math.max(take,skip);
    }
    public boolean isPred(String one,String Two){
        if(Two.length()!=one.length()+1) return false;
        int i=0,j=0;
        boolean skipped=false;
        while(i<one.length() && j<Two.length()){
            if(one.charAt(i)==Two.charAt(j)){
                i++;
                j++;
            }else{
                if(skipped) return false;
                skipped=true;
                j++;
            }     
        }
    return true;
    }

    //Bottom up
     //     Arrays.sort(words,(a,b)->a.length()-b.length());
    //     int n=words.length;
    //     int dp[]=new int[n];
    //     Arrays.fill(dp,1);
    //     int ans=0;
    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<i;j++){
    //             if(predessors(words[j],words[i])){
    //                 dp[i]=Math.max(dp[i],dp[j]+1);
    //             }
    //         }
    //     ans=Math.max(ans,dp[i]);
    //     }
    // return ans;
    // }
    // public boolean predessors(String one,String two){
    //     if(two.length()!=one.length()+1) return false;
    //     boolean rep=false;
    //     int i=0,j=0;
    //     while(i<one.length() && j<two.length()){
    //         if(one.charAt(i)==two.charAt(j)){
    //             i++;
    //             j++;
    //         }else{
    //             if(rep) return false;
    //             rep=true;
    //             j++;
    //         }
    //     }
    // return true;
}