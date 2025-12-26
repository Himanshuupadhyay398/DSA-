class Solution {
    public int bestClosingTime(String customers) {
        int n=customers.length();
        int min=Integer.MAX_VALUE,total=0;
        for(int i=0;i<n;i++){
            if(customers.charAt(i)=='Y'){
                total++;
            }
        }
        int minPenalty = total;
        int bestTime = 0;
        for(int i=0;i<n;i++){
            if(customers.charAt(i)=='Y'){
                total--;
            }else{
                total++;
            }
            if(total<minPenalty) {
                minPenalty=total;
                bestTime=i + 1;
            }   
        }
        
    return bestTime;
    }
}