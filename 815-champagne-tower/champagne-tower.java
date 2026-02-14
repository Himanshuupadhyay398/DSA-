class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
    //     double dp[][]=new double[query_row+1][query_row+1];
    //     for(int i=0;i<=query_row;i++){
    //         Arrays.fill(dp[i],-1.0);
    //     }
    //     return Math.min(1.0,recurse(poured,query_row,query_glass,dp));
    // }

    // public double recurse(int poured,int i,int j,double dp[][]){

    //     if(i<j || i<0 || j<0) return 0.0;
    //     if(i==0 && j==0) return poured;

    //     if(dp[i][j]!=-1.0) return dp[i][j];

    //     double upLeft=(recurse(poured,i-1,j-1,dp)-1)/2.0;
    //     double upRight=(recurse(poured,i-1,j,dp)-1)/2.0;

    //     if(upLeft<0) upLeft=0.0;
    //     if(upRight<0) upRight=0.0;

    // return dp[i][j]=upLeft+upRight;
    //

        double dp[][]=new double[query_row+1][query_row+1];
        for(int i=0;i<=query_row;i++){
            Arrays.fill(dp[i],0.0);
        }
        dp[0][0]=poured;
        for(int i=0;i<query_row;i++){
            for(int j=0;j<=i;j++){
                double val=(dp[i][j]-1)/2.0;
                if(val>=0.0){
                    dp[i+1][j]+=val;
                    dp[i+1][j+1]+=val;
                }
            }
        }
    return Math.min(1.0,dp[query_row][query_glass]);
    }
}