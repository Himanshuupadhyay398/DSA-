class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        ArrayList<String> result=new ArrayList<>();
        if(turnedOn>8) return result;

        int hour=0;
        int minute=0;
        for(int i=0;i<12;i++){
            for(int j=0;j<60;j++){
                if(Integer.bitCount(i)+Integer.bitCount(j)==turnedOn){
                    result.add(i+":"+(j<10?"0"+j:j));
                }
            }
        }
    return result;
    }
}