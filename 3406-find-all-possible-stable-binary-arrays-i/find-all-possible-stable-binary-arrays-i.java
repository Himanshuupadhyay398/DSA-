class Solution {
    int mod=1000000007;
    int dp[][][]=new int[201][201][2];
    public int numberOfStableArrays(int zero, int one, int limit) {
    //     for(int i=0;i<=zero;i++){
    //         for(int j=0;j<=one;j++){
    //             dp[i][j][0] = -1;
    //             dp[i][j][1] = -1;
    //         }
    //     }
    //     int startZero=solve(zero,one,limit,false);
    //     int startOne=solve(zero,one,limit,true);

    //     return (startZero+startOne)%mod;
    // }
    // public int solve(int zeroRem,int oneRem,int limit,boolean last){
    //     if(zeroRem==0 && oneRem==0){
    //         return 1;
    //     }
    //     int idx=last?1:0;
    //     if(dp[zeroRem][oneRem][idx]!=-1) return dp[zeroRem][oneRem][idx];
    //     long result=0;
    //     if(last && oneRem>0){
    //         for(int i=1;i<=Math.min(limit,oneRem);i++){
    //             result=(result+solve(zeroRem,oneRem-i,limit,false))%mod;
    //         }
    //     }
    //     if(!last && zeroRem>0){
    //         for(int i=1;i<=Math.min(limit,zeroRem);i++){
    //             result=(result+solve(zeroRem-i,oneRem,limit,true))%mod;
    //         }
    //     }
    // return dp[zeroRem][oneRem][idx]=(int)result;
    // }


    //tabular 
        for(int i=0;i<=zero;i++){
            for(int j=0;j<=one;j++){
                dp[i][j][0] = 0;
                dp[i][j][1] = 0;
            }
        }
        dp[0][0][1]=1;
        dp[0][0][0]=1;
        for(int leftZero=0;leftZero<=zero;leftZero++){
            for(int leftOne=0;leftOne<=one;leftOne++){
                if(leftZero==0 && leftOne==0) continue;
                int result=0;

                for(int len=1;len<=Math.min(limit,leftZero);len++){
                    result=(result+dp[leftZero-len][leftOne][0])%mod;
                }
                dp[leftZero][leftOne][1]=result;

                result=0;
                for(int len=1;len<=Math.min(limit,leftOne);len++){
                    result=(result+dp[leftZero][leftOne-len][1])%mod;
                }
                dp[leftZero][leftOne][0]=result;
            }
   
        }
        int startzero=dp[zero][one][0];
        int startone=dp[zero][one][1];
    return (startzero+startone)%mod;
    }
}