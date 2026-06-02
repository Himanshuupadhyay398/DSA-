class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int ans=Integer.MAX_VALUE;

        int n=landStartTime.length;
        int m=waterStartTime.length;

        for (int i = 0; i < n; i++) {
            int landFinish = landStartTime[i] + landDuration[i];

            for (int j = 0; j < m; j++) {
                ans = Math.min(ans,
                        Math.max(landFinish, waterStartTime[j])
                        + waterDuration[j]);
            }
        }

        for (int i = 0; i < m; i++) {
            int waterFinish = waterStartTime[i] + waterDuration[i];

            for (int j = 0; j < n; j++) {
                ans = Math.min(ans,
                        Math.max(waterFinish, landStartTime[j])
                        + landDuration[j]);
            }
        }

    return ans;
    }
}