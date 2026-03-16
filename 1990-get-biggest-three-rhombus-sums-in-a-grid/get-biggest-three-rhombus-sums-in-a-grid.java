class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        TreeSet<Integer> st=new TreeSet<>();
        for(int r=0;r<m;r++){
            for(int c=0;c<n;c++){
                addset(st,grid[r][c]);
                for(int side=1;r-side>=0 && r+side<m && c-side>=0 && c+side<n;side++){
                    int sum=0;

                    for(int k=0;k<side;k++){
                        sum+=grid[r-side+k][c+k];
                        sum+=grid[r+k][c+side-k];
                        sum+=grid[r+side-k][c-k];
                        sum+=grid[r-k][c-side+k];
                    }
                    addset(st,sum);
                }
            }
        }
    return buildanswer(st);
    }
    private void addset(TreeSet<Integer> st,int val){
        st.add(val);
        if(st.size()>3){
            st.pollFirst();
        }
    }
    private int[] buildanswer(TreeSet<Integer> st){
        int result[]=new int[st.size()];
        int index=0;
        Iterator<Integer> it=st.descendingIterator();
        while(it.hasNext())
            result[index++]=it.next();

        return result;
    }
}