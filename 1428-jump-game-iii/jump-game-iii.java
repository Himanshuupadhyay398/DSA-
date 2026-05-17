class Solution {
    public boolean canReach(int[] arr, int start) {
        return recurse(arr,start);
    }

    public boolean recurse(int arr[],int index){
        if(index>=arr.length || index<0) return false;
        if(arr[index]<0) return false;
        if(arr[index]==0) return true;
        
        arr[index]=-arr[index];
        boolean check=recurse(arr,index+arr[index]);
        boolean check1=recurse(arr,index-arr[index]);
    return check || check1;
    }
}