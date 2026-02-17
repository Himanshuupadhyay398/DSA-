class Solution {
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O' && (i==0 || j==0 || i==n-1 || j==m-1)){
                    dfs(board,i,j);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='#'){
                   board[i][j]='O';
                }else{
                    board[i][j]='X';
                }
            }
        }
    }
    public void dfs(char board[][],int i,int j){
        int n=board.length;
        int m=board[0].length;

        int dx[]={1,-1,0,0};
        int dy[]={0,0,1,-1};
        
        board[i][j]='#';

        for(int k=0;k<4;k++){
            int nrow=i+dx[k];
            int ncol=j+dy[k];

            if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && board[nrow][ncol]=='O'){
                dfs(board,nrow,ncol);
            }
        }
    }
}