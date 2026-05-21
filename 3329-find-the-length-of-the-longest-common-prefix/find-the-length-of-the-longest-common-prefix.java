class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            int n=arr1[i];
            while (n > 0){
                set.add(n);
                n/= 10;
            }
        }
        int ans = 0;
        for (int num : arr2) {
            while (num > 0) {
                if (set.contains(num)) {
                    int l = String.valueOf(num).length();
                    ans = Math.max(ans, l);
                }
                num /= 10;
            }
        }
        return ans;
    }
}