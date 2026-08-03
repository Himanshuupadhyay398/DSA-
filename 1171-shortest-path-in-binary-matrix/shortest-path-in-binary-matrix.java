class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        int n=grid.length;
        int m=grid[0].length;

        if(grid[0][0]==1 || grid[n-1][m-1]==1) return -1;

        if(n==1) return 1;

        Queue<int[]> q=new LinkedList<>();
        boolean visited[][]=new boolean[n][m];
        q.add(new int[]{0,0,1});
        visited[0][0]=true;

        int direction[][]={{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};


        while(!q.isEmpty()){
            int curr[]=q.poll();
            int r=curr[0];
            int c=curr[1];
            int d=curr[2];
            
            if(r==n-1 && c==m-1) return d;
            for(int dist[]:direction){
                int nr=r+dist[0];
                int nc=c+dist[1];

                if(nr>=0 && nr<n && nc>=0 && nc<m && !visited[nr][nc] && grid[nr][nc]!=1){
                        visited[nr][nc]=true;
                        q.add(new int[]{
                            nr,nc,d+1
                        });
                }
            }
        }
    return -1;
    }
}