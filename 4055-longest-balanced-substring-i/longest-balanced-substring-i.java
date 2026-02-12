class Solution {
    public int longestBalanced(String s) {
        int n=s.length();
        int max=0;
        for(int i=0;i<n;i++){
            int arr[]=new int[26];
            for(int j=i;j<n;j++){
                arr[s.charAt(j)-'a']++;
                if(isBalanced(arr)){
                    max=Math.max(max,j-i+1);
                }
                
            }
        }
    return max;
    }
    public boolean isBalanced(int arr[]){
        int currDist=0;
        for(int i=0;i<26;i++){
            if(arr[i]==0) continue;
            if(currDist==0){
                currDist=arr[i];
            }else if(arr[i]!=currDist){
                return false;
            }
        }
    return true;
    }
}