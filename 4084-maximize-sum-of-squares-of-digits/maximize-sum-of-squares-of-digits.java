class Solution {
    public String maxSumOfSquares(int num, int sum) {
       if(sum>9*num) return "";
       StringBuilder str=new StringBuilder();

       int nines=sum/9;
       sum-=nines*9;
       while(nines>0){
        str.append('9');
        nines--;
       }
        if (sum > 0) {
            str.append((char) ('0' + sum));
        }
       while(str.length()<num){
        str.append('0');
       }
    return str.toString();
    }
}