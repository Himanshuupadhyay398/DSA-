class Solution {
    public int concatenatedBinary(int n) {
        int mod=1000000007;
        StringBuilder s=new StringBuilder();
        for(int i=1;i<=n;i++){
            s.append(Integer.toBinaryString(i));
        }
        long answer=0;
        long power=1;
        for(int i=s.length()-1;i>=0;i--){
            int pos=s.length()-1-i;
            if(s.charAt(i)=='1' && i==s.length()-1){
                answer++;
            }else if(s.charAt(i)=='1'){
                answer=(answer+power) % mod;
            }
            power=(2*power) % mod;
        }
    return (int)answer;
    }
}