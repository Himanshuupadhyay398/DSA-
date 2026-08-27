class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n=s.length();
        int i=0;
        int min=Integer.MAX_VALUE;
        int st=0;
        for(int j=0;j<n;j++){

            if(s.charAt(j)=='1'){
                k--;
            }       
            while(k==0){
                if(j-i+1<min){
                    min=j-i+1;
                    st=i;
                }else if (j-i+1 == min) {
                    String curr = s.substring(i, j + 1);
                    String prev = s.substring(st, st + min);

                    if (curr.compareTo(prev) < 0) {
                        st = i;
                    }
                }
                k+=s.charAt(i)=='1'?1:0;
                i++;
            }
        }
    return min==Integer.MAX_VALUE?"":s.substring(st,st+min);
    }
}