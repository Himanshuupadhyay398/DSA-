class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int n=mat.length;
        int m=mat[0].length;
        int matClone[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                matClone[i][j]=mat[i][j];
            }
        }
        for(int swap=0;swap<k;swap++){

            for(int i=0;i<n;i++){
                for(int j=1;j<m;j++){
                    if(i%2==0){
                        int temp=matClone[i][j-1];
                        matClone[i][j-1]=matClone[i][j];
                        matClone[i][j]=temp;
                    }else{
                        int temp=matClone[i][m-j];
                        matClone[i][m-j]=matClone[i][m-j-1];
                        matClone[i][m-j-1]=temp;
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]!=matClone[i][j]) return false;
            }
        }
    return true;
    }
}