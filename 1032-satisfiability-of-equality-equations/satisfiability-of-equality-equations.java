class Solution {
    int find(int u,int[]parent){
        if(u==parent[u]){
            return u;
        }
        return parent[u]=find(parent[u],parent);
    }

    void union(int u,int v,int parent[],int []rank){
        int parent_u=find(u,parent);
        int parent_v=find(v,parent);

        if(parent_u==parent_v) return;
        if(rank[parent_u]>rank[parent_v]){
            parent[parent_v]=parent_u;
        }else if(rank[parent_u]<rank[parent_v]){
            parent[parent_u]=parent_v;
        }else{
            rank[parent_u]++;
            parent[parent_u]=parent_v;
        }

    }
    public boolean equationsPossible(String[] equations) {
        int parent[]=new int[26];
        int rank[]=new int[26];
        for(int i=0;i<26;i++){
            parent[i]=i;
        }
        for(String s:equations){
            if(s.charAt(1)=='='){
                union(s.charAt(0)-'a',s.charAt(3)-'a',parent,rank);
            }
        }
        for(String s:equations){
            if(s.charAt(1)=='!'){
                int parentu=find(s.charAt(0)-'a',parent);
                int parentv=find(s.charAt(3)-'a',parent);

                if(parentu==parentv) return false;
            }
        }
    return true;
    }
}