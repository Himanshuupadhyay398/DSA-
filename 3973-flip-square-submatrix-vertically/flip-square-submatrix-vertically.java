class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        

        for(int i=y;i<=y+k-1;i++){
            for(int j=0;j<k/2;j++){
                int temp=grid[j+x][i];
                grid[j+x][i]=grid[x+k-j-1][i];
                grid[x+k-j-1][i]=temp;
            }
        }
    return grid;
    }
}