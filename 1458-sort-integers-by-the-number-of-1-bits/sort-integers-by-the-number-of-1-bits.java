class Solution {
    public int[] sortByBits(int[] arr) {
        int n=arr.length;
        Integer result[]=new Integer[n];
        for(int i=0;i<n;i++){
            result[i]=arr[i];
        }

        Arrays.sort(result,(a,b)->{
            int countA=Integer.bitCount(a);
            int countB=Integer.bitCount(b);
            if(countA==countB){
                return a-b;
            }
        return countA-countB;
            
        });

        for(int i=0;i<n;i++){
            arr[i]=result[i];
        }
    return arr;
    }
}