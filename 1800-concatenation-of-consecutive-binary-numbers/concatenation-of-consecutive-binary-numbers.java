class Solution {
    public int concatenatedBinary(int n) {
        int mod=1000000007;
        int count=0;
        long result=0;
        for(int i=1;i<=n;i++){
            if ((i&(i - 1)) == 0){
                count++;
            }
            result=((result<<count)+i)%mod;
        }
    return (int)result;
    }
}