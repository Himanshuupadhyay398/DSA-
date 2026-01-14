class Solution {
    int N,M,K;
    int MOD=1000000007;
    public int numOfArrays(int n, int m, int k) {
        N=n;M=m;K=k;
        int dp[][][]=new int[n+1][k+1][m+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=k;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return recurse(dp,0,0,0);
    }
    public int recurse(int dp[][][],int index,int searchCost,int maxValue){
        if (searchCost > K) return 0;
        if(index==N){
            if(searchCost==K){
                return 1;
            }
            return 0;
        }
        if(dp[index][searchCost][maxValue]!=-1){
            return dp[index][searchCost][maxValue];
        }
        int result=0;
        for(int i=1;i<=M;i++){
            if(i>maxValue){
                result=(result+recurse(dp,index+1,searchCost+1,i))%MOD;
            }else{
                result=(result+recurse(dp,index+1,searchCost,maxValue))%MOD;
            }

        }
        return dp[index][searchCost][maxValue]=result % MOD;
    }
}