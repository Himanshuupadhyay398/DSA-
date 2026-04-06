class Solution {
    public boolean judgeCircle(String moves) {
        int n=moves.length();
        int currenti=0;
        int currentj=0;
        for(int i=0;i<n;i++){
            if(moves.charAt(i)=='L'){
                currentj--;
            }else if(moves.charAt(i)=='U'){
                currenti--;
            }else if(moves.charAt(i)=='D'){
                currenti++;
            }else{
                currentj++;
            }
        }
        if(currenti!=0 || currentj!=0) return false;
    return true;
    }
}