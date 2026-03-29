class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n=points.length;
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            int x=points[i][0];
            int y=points[i][1];

            arr[i]=(int)(Math.pow(x,2)+Math.pow(y,2));

        }
        Integer index[]=new Integer[n];
        for(int i=0;i<n;i++) index[i]=i;

        Arrays.sort(index,(a,b)-> arr[a]-arr[b]);

        int result[][]=new int[k][2];
        for(int i=0;i<k;i++){
            result[i]=points[index[i]];
        }
    return result;
        
    }
}