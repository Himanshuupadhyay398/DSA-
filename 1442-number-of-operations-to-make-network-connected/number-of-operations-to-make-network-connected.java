class Solution {
    int find(int u,int []parent){
        if(u==parent[u]){
            return u;
        }

        return parent[u]=find(parent[u],parent);
    }
    void union(int u,int v,int parent[],int []rank){
        int parentu=find(u,parent);
        int parentv=find(v,parent);

        if(parentu==parentv) return;

        if(rank[parentu]>rank[parentv]){
            parent[parentv]=parentu;
        }else if(rank[parentv]>rank[parentu]){
            parent[parentu]=parentv;
        }else{
            rank[parentu]++;
            parent[parentv]=parentu;
        }
    }
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1) return -1;
        int parent[]=new int[n];
        int rank[]=new int[n];

        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=0;
        }
        for(int i=0;i<connections.length;i++){
            int u=connections[i][0];
            int v=connections[i][1];

            int parentu=find(u,parent);
            int parentv=find(v,parent);
            if(parentu!=parentv){
                union(u,v,parent,rank);
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(find(i,parent)==i){
                count++;
            }
        }
    return count-1;
    }
}