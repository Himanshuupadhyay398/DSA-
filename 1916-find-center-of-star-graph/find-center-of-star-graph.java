class Solution {
    public int findCenter(int[][] edges) {
    //     int n=edges.length;
    //     int count[]=new int[n+1];

    //     for(int i=0;i<n;i++){
    //         int u=edges[i][0];
    //         int v=edges[i][1];
    //         count[u-1]++;
    //         count[v-1]++;
    //     }
    //     int max=0,result=0;
    //     for(int i=0;i<count.length;i++){
    //         if(count[i]>max){
    //             max=count[i];
    //             result=i+1;
    //         }
    //     }
    // return result;

    int a=edges[0][0];
    int b=edges[0][1];
    int c=edges[1][0];
    int d=edges[1][1];
    if(a==c || a==d) return a;
    return b;
    }
}