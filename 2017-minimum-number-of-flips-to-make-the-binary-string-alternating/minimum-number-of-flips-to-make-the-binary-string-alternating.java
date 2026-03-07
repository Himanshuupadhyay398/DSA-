class Solution {
    public int minFlips(String s) {
        int n=s.length();
        s=(s+s);
        StringBuilder s1=new StringBuilder();
        StringBuilder s2=new StringBuilder();
        for(int i=0;i<2*n;i++){
           if(i%2==0){
                s1.append('0');
                s2.append('1');
           } else{
                s1.append('1');
                s2.append('0');
           }
        }

        int count1=0,count2=0;
        int result=Integer.MAX_VALUE;

        int i=0;
        int j=0;
        while(j<2*n){
            if(s.charAt(j)!=s1.charAt(j)){
                count1++;
            }
            if(s.charAt(j)!=s2.charAt(j)){
                count2++;
            }

            if((j-i+1)>n){
                if(s.charAt(i)!=s1.charAt(i)){
                    count1--;
                }
                if(s.charAt(i)!=s2.charAt(i)){
                    count2--;
                }
                i++;
            }
            if(j-i+1==n){
                result=Math.min(result,Math.min(count1,count2));
            }
            j++;
        }
    return result;
    }
}