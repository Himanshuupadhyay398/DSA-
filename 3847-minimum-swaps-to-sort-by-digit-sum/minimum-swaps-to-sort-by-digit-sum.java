class Solution {
    public int minSwaps(int[] nums) {
        int n=nums.length;
        HashMap<Integer,int[]> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int val=nums[i];
            int sum=0;
            while(val>0){
                sum+=val%10;
                val=val/10;
            }
            map.put(i,new int[]{nums[i],sum});
        }
        List<Map.Entry<Integer,int[]>> list=new ArrayList<>(map.entrySet());
        list.sort((a,b) ->{
            int x[]=a.getValue();
            int y[]=b.getValue();

            if(x[1]!=y[1]) return Integer.compare(x[1],y[1]);
            return Integer.compare(x[0],y[0]);
        });

        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || list.get(i).getKey() == i) {
                visited[i] = true;
                continue;
            }

            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = list.get(j).getKey();
                cycleSize++;
            }

            if (cycleSize > 1) {
                swaps += cycleSize - 1;
            }
        }

        return swaps;


    }
}