class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int []node:invocations){
            adj.get(node[0]).add(node[1]);
        }

        boolean visited[]=new boolean[n];

        dfs(adj,visited,k);
        for(int node[]:invocations){
            int u=node[0];
            int v=node[1];
            if(!visited[u] && visited[v]){
                List<Integer>result=new ArrayList<>();
                for(int i=0;i<n;i++){
                    result.add(i);
                }
                return result;
            }
        }
        List<Integer>result=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!visited[i]){
                result.add(i);
            }
        }  
    return result;      
    }

    public void dfs(ArrayList<ArrayList<Integer>> adj, boolean visited[], int node) {
        visited[node] = true;
        for (int neigh : adj.get(node)) {
            if (!visited[neigh])
                dfs(adj, visited, neigh);
        }
    }
}