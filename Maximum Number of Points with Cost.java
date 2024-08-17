class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long[] dp = new long[n];

        for (int j = 0; j < n; j++) {
            dp[j] = points[0][j];
        }

        for (int i = 1; i < m; i++) {
            long[] newDp = new long[n];

            long leftMax = dp[0];
            for (int j = 0; j < n; j++) {
                leftMax = Math.max(leftMax, dp[j] + j);
                newDp[j] = leftMax + points[i][j] - j;
            }

            long rightMax = dp[n - 1] - (n - 1);
            for (int j = n - 1; j >= 0; j--) {
                rightMax = Math.max(rightMax, dp[j] - j);
                newDp[j] = Math.max(newDp[j], rightMax + points[i][j] + j);
            }

            dp = newDp;
        }

        long result = 0;
        for (int j = 0; j < n; j++) {
            result = Math.max(result, dp[j]);
        }

        return result;
    }
}
