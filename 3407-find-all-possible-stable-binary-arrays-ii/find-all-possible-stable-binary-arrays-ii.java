class Solution {
    int mod=1000000007;
    public int numberOfStableArrays(int zero, int one, int limit) {
        int dp[][][]=new int[zero+1][one+1][2];
        for(int i=1;i<=Math.min(limit,zero);i++){
            dp[i][0][0]=1;
        }
        for(int i=1;i<=Math.min(limit,one);i++){
            dp[0][i][1]=1;
        }

        for(int zeroR=0;zeroR<=zero;zeroR++){
            for(int oneR=0;oneR<=one;oneR++){
                if(zeroR==0 || oneR==0) continue;
                dp[zeroR][oneR][0]=(dp[zeroR][oneR][0]+dp[zeroR-1][oneR][0]+dp[zeroR-1][oneR][1])%mod;

                if(zeroR-1>=limit){
                    dp[zeroR][oneR][0]=
                        ((dp[zeroR][oneR][0]-dp[zeroR-1-limit][oneR][1])+mod)%mod;
                }

                dp[zeroR][oneR][1]=(dp[zeroR][oneR][1]+dp[zeroR][oneR-1][1]+dp[zeroR][oneR-1][0])%mod;

                if(oneR-1>=limit){
                    dp[zeroR][oneR][1]=
                        (dp[zeroR][oneR][1]-dp[zeroR][oneR-1-limit][0]+mod)%mod;
                }
                

            }
        }

    return (dp[zero][one][0]+dp[zero][one][1])%mod;
    }
}