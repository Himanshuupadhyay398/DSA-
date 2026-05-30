class Solution {
    public int longestPalindrome(String s) {
        int n = s.length();
        int[] upper = new int[26];
        int[] lower = new int[26];

        for (int i = 0; i < n; i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                upper[s.charAt(i) - 'A']++;
            } else {
                lower[s.charAt(i) - 'a']++;
            }
        }
        int ans = 0;
        boolean oddFound = false;

        for (int i = 0; i < 26; i++) {

            if (upper[i] % 2 == 0) {
                ans += upper[i];
            } else {
                ans += upper[i] - 1;
                oddFound = true;
            }

            if (lower[i] % 2 == 0) {
                ans += lower[i];
            } else {
                ans += lower[i] - 1;
                oddFound = true;
            }
        }

        if (oddFound)
            ans++;

        return ans;
    }
}