class Solution {
    public int[][] updateMatrix(int[][] mat) {
         int n = mat.length;
        int m = mat[0].length;

        int[][] dist = new int[n][m];
        boolean[][] vis = new boolean[n][m];

        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j,0});
                    vis[i][j]=true;
                }
            }
        }

        int[] dr={-1,0,1,0};
        int[] dc={0,1,0,-1};

        while(!q.isEmpty()){
            int[] cur=q.poll();
            int r=cur[0], c=cur[1], d=cur[2];

            dist[r][c]=d;

            for(int k=0;k<4;k++){
                int nr=r+dr[k];
                int nc=c+dc[k];

                if(nr>=0 && nc>=0 && nr<n && nc<m && !vis[nr][nc]){
                    vis[nr][nc]=true;
                    q.add(new int[]{nr,nc,d+1});
                }
            }
        }

        
        return dist;
    }
}