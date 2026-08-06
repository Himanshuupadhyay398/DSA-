class Solution {
    public int smallestNumber(int n, int t) {
        for(int i=n;i<=n+10;i++){
        int result=1;
        int temp = i;
            while(temp>0){
                result=result*(temp%10);
                temp=temp/10;
            }
            if((result%t)==0){
                return i;
            }
        }
    return 0;
    }
}