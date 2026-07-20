class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<k;i++){
            for(int q=n-1;q>0;q--){
                    int temp=grid[q][m-1];
                    grid[q][m-1]=grid[q-1][m-1];
                    grid[q-1][m-1]=temp;
            }

            for(int j=0;j<n;j++){
                for(int l=m-1;l>0;l--){
                     int temp=grid[j][l];
                    grid[j][l]=grid[j][l-1];
                    grid[j][l-1]=temp;
                }
            }
        }
        for(int i=0;i<n;i++){
            List<Integer> lst=new ArrayList<>();
            for(int j=0;j<m;j++){
                lst.add(grid[i][j]);
            }
            result.add(lst);
        }
    return result;
    }
}