class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int result[]=new int[n];
        Arrays.fill(result,0);
        Stack<int[]> stack=new Stack<>();
        for(int i=0;i<n;i++){
            
            while(!stack.isEmpty() && stack.peek()[0]<temperatures[i]){
                int curr[]=stack.pop();
                int index=curr[1];
                result[index]=i-index;
            }
            stack.push(new int[]{temperatures[i],i});
        }
    return result;
    }
}