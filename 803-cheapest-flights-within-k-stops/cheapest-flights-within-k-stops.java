class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj=new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int fligh[]:flights){
            adj.get(fligh[0]).add(new int[]{fligh[1],fligh[2]});
        }

        Queue<int[]> q=new LinkedList<>();
        int dist[]=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        q.add(new int[]{src,0,0});

        while(!q.isEmpty()){
            int arr[]=q.poll();
            int node=arr[0];
            int cost=arr[1];
            int stop=arr[2];

            if(stop>k) continue;
            for(int[] neigh:adj.get(node)){
                
                int next=neigh[0];
                int price=neigh[1];

                if(cost+price < dist[next]){

                    dist[next]=cost+price;

                    q.add(new int[]{next,cost+price,stop+1});
                }
            }
        }
    return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];
    }
}