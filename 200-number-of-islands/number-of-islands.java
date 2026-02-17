class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        int visited[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && visited[i][j]!=1){
                    dfs(grid,i,j,visited);
                    count++;
                }
            }
        }
    return count;
    }
    public void dfs(char[][] grid,int i,int j,int visited[][]){
        int n=grid.length;
        int m=grid[0].length;

        int dx[]={1,-1,0,0};
        int dy[]={0,0,1,-1};
        visited[i][j]=1;

        for(int k=0;k<4;k++){
            int nrow=i+dx[k];
            int ncol=j+dy[k];

            if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && grid[nrow][ncol]=='1' && visited[nrow][ncol]==0){
                visited[nrow][ncol]=1;
                dfs(grid,nrow,ncol,visited);
            }
        }
    }
}