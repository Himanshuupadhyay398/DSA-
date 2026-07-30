class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int block = n / 8;
        return (block * (block + 1) * 4) + (n % 8) * (block + 1);
    }
}