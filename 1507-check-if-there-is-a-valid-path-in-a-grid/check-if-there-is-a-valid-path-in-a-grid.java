class Solution {
    public boolean hasValidPath(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int dis[][][]=new int[7][][];
        dis[1]=new int[][]{{0,-1},{0,1}};
        dis[2]=new int[][]{{-1,0},{1,0}};
        dis[3]=new int[][]{{0,-1},{1,0}};
        dis[4]=new int[][]{{0,1},{1,0}};
        dis[5]=new int[][]{{0,-1},{-1,0}};
        dis[6]=new int[][]{{0,1},{-1,0}};

        boolean vist[][]=new boolean[n][m];
        Queue<int[]> q=new LinkedList<>();

        q.offer(new int[]{0,0});
        vist[0][0]=true;
        while(!q.isEmpty()){
            int curr[]=q.poll();
            int r=curr[0],l=curr[1];

            if(r==n-1 && l==m-1)
                return true;

            for(int edg[]:dis[grid[r][l]]){
                int nr=r+edg[0];
                int nl=l+edg[1];

                if(nr<0 || nl<0 || nr>=n || nl>=m || vist[nr][nl]){
                    continue;
                }
                for(int[] back : dis[grid[nr][nl]]){
                    if(nr + back[0] == r && nl + back[1] == l){
                        vist[nr][nl] = true;
                        q.offer(new int[]{nr,nl});
                    }
                }
            }
        }
    return false;
    }
}