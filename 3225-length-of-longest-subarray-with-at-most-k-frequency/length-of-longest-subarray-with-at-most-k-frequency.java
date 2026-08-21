class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int j = 0;
        int len = 0;
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            int val = map.get(nums[i]);
            while (map.get(nums[i]) > k) {
                map.put(nums[j], map.getOrDefault(nums[j], 0) - 1);
                j++;
            }
            len = Math.max(len, i - j + 1);
        }
        return len;
    }
}