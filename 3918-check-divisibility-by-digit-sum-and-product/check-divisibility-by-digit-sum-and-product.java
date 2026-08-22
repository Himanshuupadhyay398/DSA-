class Solution {
    public boolean checkDivisibility(int n) {
        int temp=n;
        int sum=0,mul=1;
        while(temp>0){
            int val=temp%10;
            sum+=val;
            mul*=val;
            temp=temp/10;
        }
        return n%(sum+mul)==0;
    }
}