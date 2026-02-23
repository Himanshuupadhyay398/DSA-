class Solution {
    public boolean hasAllCodes(String s, int k) {
       int n=s.length();
       int i=0;
       HashSet<String> hash=new HashSet<>();
        while(i<=n-k){
            int j=i;
            String str="";
            while(j-i+1<=k){
                str+=s.charAt(j);
                j++;
            }
            hash.add(str);
            i++;
        }
    return hash.size()==(int)Math.pow(2,k)?true:false;
    }
}