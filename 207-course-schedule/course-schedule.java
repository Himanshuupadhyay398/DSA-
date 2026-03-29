class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

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
        int count=0;
        while(!q.isEmpty()){
            int node=q.poll();
            count++;
            for(int n:adj.get(node)){
                indegree[n]--;
                if(indegree[n]==0){
                    q.add(n);
                }
            }
        }
    return count==numCourses;
    }
}