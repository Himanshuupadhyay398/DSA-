class Solution {
    public String[] createGrid(int m, int n) {
        char arr[][]=new char[m][n];
        for(int i=0;i<m-1;i++){
            Arrays.fill(arr[i],'#');
        }

        for(int i=0;i<m;i++){
            arr[i][0]='.';
        }
        for(int i=0;i<n;i++){
            arr[m-1][i]='.';
        }
        
        String result[]=new String[m];
        for(int i=0;i<m;i++){
            StringBuilder st=new StringBuilder();
            for(int j=0;j<n;j++){
                st.append(arr[i][j]);
            }
            result[i]=st.toString();
        }
    return result;
    }
}