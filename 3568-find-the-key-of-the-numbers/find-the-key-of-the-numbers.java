class Solution {
    public int generateKey(int num1, int num2, int num3) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<4;i++){
            int min1=0, min2=0,min3=0;

            min1=num1%10;
            min2=num2%10;
            min3=num3%10;

            sb.append(Math.min(min1,Math.min(min2,min3)));

            num1=num1/10;
            num2=num2/10;
            num3=num3/10;

        }
        return Integer.parseInt(sb.reverse().toString());
    }
}