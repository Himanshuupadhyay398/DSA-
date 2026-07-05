class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int road[]:roads){
            adj.get(road[0]).add(new int[]{road[1],road[2]});
            adj.get(road[1]).add(new int[]{road[0],road[2]});
        }
        int min=Integer.MAX_VALUE;
        boolean visited[]=new boolean[n+1];
        min=dfs(adj,visited,1,min);
    return min;
    }
    public int dfs(List<List<int[]>> adj,boolean visited[],int node,int min){
        visited[node]=true;
        for(int neigh[]:adj.get(node)){
            min=Math.min(min,neigh[1]);
            if(!visited[neigh[0]]){
                min=dfs(adj,visited,neigh[0],min);
            }
        }
    return min;
    }
}