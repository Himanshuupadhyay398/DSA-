class Solution {
    public char[] reverse(char[] arr, int i, int j){
        while(i < j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return arr;
    }
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int i = 0, j = i + 1;
        while(j < n){
            if(arr[j] != ' ') j++;
            else {
                reverse(arr, i, j - 1);
                j++;
                i = j;
            }
        }
        reverse(arr, i, j - 1);
        return new String(arr);
    }
}