class Solution {
    public boolean containsCycle(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int visited[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], 0);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0) {
                    if(dfs(grid, visited, i, j, -1, -1, grid[i][j])){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char grid[][], int visited[][], int i, int j, int pi, int pj, char prev) {
        int n = grid.length;
        int m = grid[0].length;
        visited[i][j] = 1;
        int dx[] = { -1, 1, 0, 0 };
        int dy[] = { 0, 0, 1, -1 };

        for (int d = 0; d < 4; d++) {
            int nx = i + dx[d];
            int ny = j + dy[d];

            if(nx>=0 && ny>=0 && nx<n && ny<m && grid[nx][ny]==prev){
                if(visited[nx][ny]==0){
                    if(dfs(grid,visited,nx,ny,i,j,prev)){
                        return true;
                    }
                }else if(nx!=pi || ny!=pj){
                    return true;
                }
            }
        }
    return false;
    }
}