class Solution {
    public int findLongestChain(int[][] pairs) {

        //memoization
        int n=pairs.length;
    //     Arrays.sort(pairs,(a,b)->a[1]-b[1]);
    //     int dp[][]=new int[n+1][n+1];
    //     for(int i=0;i<n;i++){
    //         Arrays.fill(dp[i],-1);
    //     }
    //     return recurse(0,dp,pairs,-1);
    // }
    // public int recurse(int i,int dp[][],int [][]pairs,int p){
    //     if(i>=pairs.length) return 0;
    //     if(dp[i][p+1]!=-1) return dp[i][p+1];
    //     int take=0;
    //     if(p==-1 || pairs[i][0]>pairs[p][1]){
    //         take=1+recurse(i+1,dp,pairs,i);
    //     }
    //     int skip=recurse(i+1,dp,pairs,p);
    //     return dp[i][p+1]=Math.max(take,skip);

    //tabulation
        Arrays.sort(pairs,(a,b)->a[1]-b[1]);
        int count=1;
        int prev=0;
        for(int i=1;i<n;i++){
            if(pairs[prev][1]<pairs[i][0]){
                prev=i;
                count++;
            }
        }
    return count;
    }
}