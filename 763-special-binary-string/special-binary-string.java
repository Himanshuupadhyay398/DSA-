class Solution {
    public String makeLargestSpecial(String s) {
        int n=s.length();
        ArrayList<String> result=new ArrayList<>();
        int sum=0;
        int start=0;

        for(int i=0;i<n;i++){
            sum+=s.charAt(i)=='1'?1:-1;
            if(sum==0){
                String st=s.substring(start+1,i);
                result.add('1'+makeLargestSpecial(st)+'0');
                start=i+1;
            }
        }
    Collections.sort(result, Collections.reverseOrder());
    StringBuilder ans=new StringBuilder();
    for(String str:result) ans.append(str);
    return ans.toString();
    }
}