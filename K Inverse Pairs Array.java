class Solution {
    public int kInversePairs(int n, int k) {
        int mod = 1000000007;
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    int x = Math.max(0, j - i + 1);
                    for (int idx = x; idx <= j; idx++){
                        dp[i][j] = (dp[i][j] + dp[i - 1][idx]) % mod;
                    }
                }
            }
        }

        return dp[n][k];
    }
}
