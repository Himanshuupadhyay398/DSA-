class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n=mat.length;
        boolean deg0=true,deg90=true,deg180=true,deg270=true;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]!=target[i][j]) deg0=false;

                if(mat[i][j]!=target[j][n-i-1]) deg90=false;

                if(mat[i][j]!=target[n-i-1][n-j-1]) deg180=false;

                if(mat[i][j]!=target[n-j-1][i]) deg270=false;
            }
        }
    return deg0 || deg90 || deg180 || deg270;
    }
}