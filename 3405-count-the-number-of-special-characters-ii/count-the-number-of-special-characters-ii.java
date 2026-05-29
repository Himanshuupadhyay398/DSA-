class Solution {
    public int numberOfSpecialChars(String word) {
        boolean check[] = new boolean[26];
        int firstUpper[] = new int[26];

        Arrays.fill(firstUpper, Integer.MAX_VALUE);

        int n = word.length();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (Character.isUpperCase(ch)) {
                firstUpper[ch - 'A'] = Math.min(firstUpper[ch - 'A'], i);
            }
        }
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            if (Character.isLowerCase(ch)) {
                int idx = ch - 'a';
                if (firstUpper[idx] != Integer.MAX_VALUE) {

                    if (i < firstUpper[idx]) {
                        check[idx] = true;
                    } else {
                        check[idx] = false;
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (check[i] == true) {
                count++;
            }
        }
        return count;
    }
}