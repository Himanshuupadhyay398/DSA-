class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        int total=0,count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]!=0){
                    total++;
                }
                if(grid[i][j]==2) q.add(new int[]{i,j});
            }
        }

        int dx[]={1,0,-1,0};
        int dy[]={0,1,0,-1};
        int day=0;
        while(!q.isEmpty()){

            int rott=q.size();
            count+=rott;

            for(int i=0;i<rott;i++){

                int curr[]=q.poll();
                int r=curr[0];
                int c=curr[1];

                for(int k=0;k<4;k++){
                    int nr=r+dx[k];
                    int nc=c+dy[k];

                    if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]==1){
                        grid[nr][nc]=2;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
            if(!q.isEmpty()) day++;
        }
    return total==count?day:-1;
    }
}