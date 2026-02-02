class Solution {
    public long minimumCost(int[] nums, int k, int dist) {
        int n=nums.length;
        TreeSet<int[]> kMinimum = new TreeSet<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });
        TreeSet<int[]> remaining = new TreeSet<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        long sum=0;
        int i=1;
        while(i<n && i-dist<1){
            int []arr=new int[]{nums[i],i};
            kMinimum.add(arr);
            sum+=nums[i];
        if(kMinimum.size() > k - 1) {
                int[] largest = kMinimum.pollLast();
                sum -= largest[0];
                remaining.add(largest);
            }
            i++;
        }
        long result=Long.MAX_VALUE;
        while(i<n){
            int []arr=new int[]{nums[i],i};
            kMinimum.add(arr);
            sum+=nums[i];
            if (kMinimum.size() > k - 1) {
                int[] largest = kMinimum.pollLast();
                sum -= largest[0];
                remaining.add(largest);
            }
            result=Math.min(result,sum);

            int rem=i-dist;
            int Remove[]=new int[]{nums[rem],rem};
            if(kMinimum.remove(Remove)){
                sum-=nums[rem];
                if(!remaining.isEmpty()){
                    int[] promote = remaining.pollFirst();
                    kMinimum.add(promote);
                    sum += promote[0];
                }
            }else{
                remaining.remove(Remove);
            } 
            i++;
        }
    return nums[0]+result;
    }
}