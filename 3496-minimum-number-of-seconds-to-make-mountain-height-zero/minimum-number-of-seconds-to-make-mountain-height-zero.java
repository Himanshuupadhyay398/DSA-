class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        int maxtime=0;
        for(int workers:workerTimes){
            maxtime=Math.max(maxtime,workers);
        }
        long l=0;
        long r=(long)maxtime*mountainHeight*(mountainHeight+1)/2;
        long result=0;
        while(l<=r){
            long mid=l+(r-l)/2;
            if(check(mid,mountainHeight,workerTimes)){
                result=mid;
                r=mid-1;
            }else {
                l=mid+1;
            }
        }
        return result;
    }
    public boolean check(long mid,int mountainHeight, int[] workerTimes){
        long height=0;
        for(int t:workerTimes){
            height+=(long)(Math.sqrt(2.0*mid/t+0.25)-0.5);

            if(height>=mountainHeight) return true;

        }
    return false;
    }
}