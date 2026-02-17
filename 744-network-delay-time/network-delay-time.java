import java.util.*;

class Solution {

    static class Pair {
        int node;
        int dist;
        Pair(int n,int d){
            node=n;
            dist=d;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {

        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());

        for(int[] t:times)
            adj.get(t[0]).add(new Pair(t[1],t[2]));

        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.dist-b.dist);

        dist[k]=0;
        pq.add(new Pair(k,0));

        while(!pq.isEmpty()){
            Pair cur=pq.poll();
            int node=cur.node;
            int d=cur.dist;

            if(d>dist[node]) continue;

            for(Pair nb:adj.get(node)){
                int newDist=d+nb.dist;
                if(newDist<dist[nb.node]){
                    dist[nb.node]=newDist;
                    pq.add(new Pair(nb.node,newDist));
                }
            }
        }

        int ans=0;
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE) return -1;
            ans=Math.max(ans,dist[i]);
        }
        return ans;
    }
}
