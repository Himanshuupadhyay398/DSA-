class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        int result[][]=new int[n-k+1][m-k+1];
        if(k==1) return result;
        for(int i=0;i<n-k+1;i++){
            for(int j=0;j<m-k+1;j++){
                ArrayList<Integer> l=new ArrayList<>();
                for(int idx=i;idx<i+k;idx++){
                    for(int idx1=j;idx1<j+k;idx1++){
                        l.add(grid[idx][idx1]);
                    }
                }
                Collections.sort(l);
                int min=Integer.MAX_VALUE;

                for(int p=0;p<l.size()-1;p++){
                    if(!l.get(p).equals(l.get(p+1))){
                        min=Math.min(min,Math.abs(l.get(p+1)-l.get(p)));
                    }
                }
                if(min==Integer.MAX_VALUE) min=0;
                result[i][j]=min;
            }
        }
        
    return result;
    }
}