class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int n=points.length;
        int count=0;
        for(int i=0;i<n-1;i++){
            int maxX=Math.abs(points[i+1][0]-points[i][0]);
            int maxY=Math.abs(points[i+1][1]-points[i][1]);
            count+=Math.max(maxX,maxY);
        }
    return count;
    }
}