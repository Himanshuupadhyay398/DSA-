class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int indegree[]=new int[numCourses];
        for(int e[]:prerequisites){
            adj.get(e[1]).add(e[0]);  //v-->u
            indegree[e[0]]++;
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0) q.add(i);
        }

        int result[]=new int[numCourses];
        int idx=0;
        int count=0;
        while(!q.isEmpty()){
            int n=q.poll();
            count++;
            result[idx]=n ;
            idx++;
            for(int node:adj.get(n)){
                indegree[node]--;
                if(indegree[node]==0){
                    q.add(node);
                }
            }
        }
    return count==numCourses?result:new int[]{};
    }
}