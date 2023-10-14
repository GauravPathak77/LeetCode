class Solution {
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        int dp[][] = new int[n + 1][n + 1];
        
        for (int i = 1; i <= n; i++) {
            dp[n][i] = (int) 1e9;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= n; j++) {
                int ans1 = cost[i] + dp[i + 1][Math.max(0, j-1 - time[i])];
                int ans2 = dp[i + 1][j];
                dp[i][j] = Math.min(ans1, ans2);
            }
        }
        
        return dp[0][n];
    }
}
