class Solution {
    public int minimumDeletions(String s) {
        int n=s.length();
        int countb=0;
        int answer=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='b') countb++;
            else{
                answer=Math.min(answer+1,countb);
            }
        }
    return answer;
    }
}