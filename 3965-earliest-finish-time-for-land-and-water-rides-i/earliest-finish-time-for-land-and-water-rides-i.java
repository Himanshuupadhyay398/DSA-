class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        return Math.min(find(landStartTime,landDuration,waterStartTime,waterDuration)
        ,find(waterStartTime,waterDuration,landStartTime,landDuration));
    }

    public int find(int ls[], int ld[], int ws[], int wd[]) {

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < ls.length; i++) {
            min = Math.min(min, ls[i] + ld[i]);
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < ws.length; i++) {
            result = Math.min(result, Math.max(min, ws[i]) + wd[i]);
        }
        return result;
    }
}