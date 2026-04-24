class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int count=0,countL=0,countR=0;
        for(int i=0;i<moves.length();i++){
            if(moves.charAt(i)=='_'){
                count++;
            }else if(moves.charAt(i)=='L'){
                countL++;
            }else{
                countR++;
            }
        }
    return Math.abs(countL-countR)+count;
    }
}