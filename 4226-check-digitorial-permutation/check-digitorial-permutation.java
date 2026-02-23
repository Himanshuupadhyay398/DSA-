class Solution {
    public boolean isDigitorialPermutation(int n) {
        int n1=n;
        int fact[]=new int[10];
        factorial(fact);

        int sum=0;
        while(n1>0){
            int rem=n1%10;
            sum+=fact[rem];
            n1=n1/10;
        }

        return check(sum,n);
    }
    public void factorial(int fact[]){
        fact[0]=1;
        for(int i=1;i<10;i++){
            fact[i]=fact[i-1]*i;
        }
    }
    public boolean check(int sum,int n){
        int freq[]=new int[10];

        while(sum>0){
            freq[sum%10]++;
            sum/=10;
        }
        while(n>0){
            freq[n%10]--;
            n/=10;
        }

        for(int i=0;i<freq.length;i++){
            if(freq[i]!=0) return false;
        }
    return true;
    }
}