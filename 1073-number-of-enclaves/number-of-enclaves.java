class Solution {
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && (i==0 || j==0 || i==n-1 || j==m-1)){
                    dfs(grid,i,j);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                   count++;
                }
            }
        }
    return count;
    }

    public void dfs(int grid[][],int i,int j){
        int n=grid.length;
        int m=grid[0].length;

        int dx[]={1,-1,0,0};
        int dy[]={0,0,1,-1};
        
        grid[i][j]=2;

        for(int k=0;k<4;k++){
            int nrow=i+dx[k];
            int ncol=j+dy[k];

            if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && grid[nrow][ncol]==1){
                dfs(grid,nrow,ncol);
            }
        }
    }
    
}