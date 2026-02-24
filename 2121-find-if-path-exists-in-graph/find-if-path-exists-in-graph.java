class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        int visited[]=new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return dfs(adj,source,destination,visited);
    }

    public boolean dfs(List<List<Integer>> adj,int node,int dest,int visited[]){
        if(node==dest) return true;
    
        visited[node]=1;
        for(int neigh:adj.get(node)){
            if(visited[neigh]!=1){
                if(dfs(adj,neigh,dest,visited)){
                    return true;
                }
            }
        }
    return false;
    }
}