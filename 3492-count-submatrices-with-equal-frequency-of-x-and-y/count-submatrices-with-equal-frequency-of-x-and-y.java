class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int tempX[]=new int[m];
        int tempY[]=new int[m];
        int count=0;
        for(int i=0;i<n;i++){
            int rowcount=0,columncount=0;
            for(int j=0;j<m;j++){
                if(grid[i][j]=='X') rowcount++;
                else if(grid[i][j]=='Y') columncount++;

                tempX[j]+= rowcount;
                tempY[j]+= columncount;

                if(tempX[j]==tempY[j] && tempX[j]>0){
                    count++;
                }
            }
        }
    return count;
    }
}