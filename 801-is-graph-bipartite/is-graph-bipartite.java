class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int m=graph[0].length;
        int visited[]=new int[n+1];
        int color[]=new int[n+1];
        for(int i=1;i<n;i++){
            if(visited[i]!=1){
                if(!dfs(graph,visited,i,-1,color)){
                    return false;
                }
            }
        }
    return true;
    }
    public boolean dfs(int graph[][],int visited[],int node,int parent,int color[]){

        visited[node]=1;
        if(parent==-1) color[node]=0;
        else if(color[parent]==0){
            color[node]=1;
        }else{
            color[node]=0;
        }
        for(int i=0;i<graph[node].length;i++){
            if(visited[graph[node][i]]!=1){
                if(!dfs(graph,visited,graph[node][i],node,color)){
                    return false;
                }
            }else if(color[graph[node][i]]==color[node]){
                    return false;
                }
        }
    return true;
    }
}