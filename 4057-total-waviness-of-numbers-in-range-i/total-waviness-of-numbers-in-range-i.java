class Solution {
    public int totalWaviness(int num1, int num2) {
        int total = 0;
        while (num1 <= num2) {
            String s = Integer.toString(num1);
            int i = 1, j = s.length() - 2;
            while (j >= i) {
                if ((s.charAt(j) > s.charAt(j + 1) && s.charAt(j) > s.charAt(j - 1))
                        || (s.charAt(j) < s.charAt(j + 1) && s.charAt(j) < s.charAt(j - 1))) {
                    total++;
                }
                j--;
            }
            num1++;
        }
    return total;
    }
}