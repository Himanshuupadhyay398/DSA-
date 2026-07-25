class Solution {
    public int maxProduct(int n) {
        int max=0;
        int secmax=0;
        while(n>0){
            int val=n%10;
            if(val>max){
                secmax=max;
                max=val;
            }else if(val>secmax) secmax=val;
            n=n/10;
        }
    return max*secmax;
    }
}