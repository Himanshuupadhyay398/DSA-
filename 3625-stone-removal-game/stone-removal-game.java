class Solution {
    public boolean canAliceWin(int n) {
        int num=10;
        int i=1;
        while(n>=0){
            if(n-num<0){
                return i%2==1?false:true;
            }
            n=n-num;
            i++;
            num--;
        }
    return true;
    }
}