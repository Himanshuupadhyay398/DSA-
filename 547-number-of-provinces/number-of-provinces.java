class Solution {
    public int findCircleNum(int[][] isConnected) {
        int V=isConnected.length;
        int visited[]=new int[V];
        int count=0;
        for(int i=0;i<V;i++){
            if(visited[i]!=1){
                dfs(isConnected,visited,i);
                count++;
            }
        }
    return count;
    }
    public void dfs(int isConnected[][],int visited[],int node){
        visited[node]=1;
        for(int i=0;i<isConnected[node].length;i++){
            if(visited[i]!=1 && isConnected[node][i]==1){
                dfs(isConnected,visited,i);
            }
        }
    }
}