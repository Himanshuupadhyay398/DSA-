class Solution {
    int count=0;
    public int minJumps(int[] arr) {
        HashMap<Integer,List<Integer>> map=new HashMap<>();
       int n=arr.length;
        for(int i=0;i<n;i++){
            map.putIfAbsent(arr[i],new ArrayList<>());

            map.get(arr[i]).add(i);
        }
        Queue<Integer> q=new LinkedList<>();
        boolean[] visited = new boolean[n];

        q.offer(0);
        visited[0] = true;

        int jumps = 0;

        while(!q.isEmpty()){
            int size=q.size();
            for (int s = 0; s < size; s++) {

                int curr = q.poll();

                if (curr == n - 1) {
                    return jumps;
                }

                if (curr + 1 < n && !visited[curr + 1]) {
                    visited[curr + 1] = true;
                    q.offer(curr + 1);
                }

                if (curr - 1 >= 0 && !visited[curr - 1]) {
                    visited[curr - 1] = true;
                    q.offer(curr - 1);
                }

                if (map.containsKey(arr[curr])) {

                    for (int next : map.get(arr[curr])) {

                        if (!visited[next]) {
                            visited[next] = true;
                            q.offer(next);
                        }
                    }
                    map.remove(arr[curr]);
                }
            }
            jumps++;
        }
    return -1;
    }
}