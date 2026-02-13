class Solution {
    public int findCircleNum(int[][] isConnected) {
        int V=isConnected.length;
        int visited[]=new int[V+1];
        int count=0;
        for(int i=0;i<V;i++){
            if(visited[i]!=1){
                dfs(isConnected,i,visited);
                count++;
            }
        }
    return count;
    }
    public static void dfs(int [][]isConnected,int node,int visited[]){
        visited[node]=1;
        for(int j=0;j<isConnected[node].length;j++){
            if(visited[j]==0 && isConnected[node][j]==1 ){
                dfs(isConnected,j,visited);
            }
        }
    }
}