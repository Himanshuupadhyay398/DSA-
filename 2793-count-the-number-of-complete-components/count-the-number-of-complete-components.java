class Solution {

     int nodes;
    int degreeSum;

    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int edge[]:edges){
            int u=edge[0];
            int v=edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean visited[]=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                nodes = 0;
                degreeSum = 0;
                dfs(adj,i,visited);
                int edgeCount = degreeSum / 2;

                if (edgeCount == nodes * (nodes - 1) / 2) {
                    count++;
                }
            }
        }
    return count;
    }
    public void dfs(List<List<Integer>> adj,int i,boolean visited[]){
        visited[i]=true;
         nodes++;
        degreeSum += adj.get(i).size();
        for(int neigh:adj.get(i)){
            if(!visited[neigh]){
                dfs(adj,neigh,visited);
            }
        }
    }
}