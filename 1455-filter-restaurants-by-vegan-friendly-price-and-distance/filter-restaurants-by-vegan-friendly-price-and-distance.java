class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        int n=restaurants.length;
        List<Integer> result=new ArrayList<>();
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->b[1]==a[1]?b[0]-a[0]:b[1]-a[1]);


        for(int i=0;i<n;i++){
            if(restaurants[i][2]>=veganFriendly && restaurants[i][3]<=maxPrice && restaurants[i][4]<=maxDistance){
                pq.offer(restaurants[i]);
            }
        }

        while(!pq.isEmpty()){
            result.add(pq.poll()[0]);
        }
    return result;
    }

}