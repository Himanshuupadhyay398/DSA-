class Solution {
    
    public boolean cycle(int node,boolean[] visited,boolean[] onePath,int grid[][]){
        visited[node]=true;
        onePath[node]=true;

        for(int i:grid[node]){
            if(!visited[i] && cycle(i,visited,onePath,grid)){
                return true;
            }
            else if(onePath[i]) return true;
        }
        onePath[node]=false;
        return false;
    }
    
    public List<Integer> eventualSafeNodes(int[][] grid) {
        List<Integer> result=new ArrayList<>();

        boolean visited[]=new boolean[grid.length];
        boolean onePath[]=new boolean[grid.length];
        for(int i=0;i<grid.length;i++){
            
            if(!cycle(i,visited,onePath,grid)){
                result.add(i);
            }
        }
        return result;
    }
}