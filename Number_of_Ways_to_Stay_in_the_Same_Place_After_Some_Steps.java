class Solution {
    public int numWays(int steps, int arrLen) {
        int mod = 1000000007;
    
    int maxPosition = Math.min(arrLen - 1, steps / 2);
    int[][] dp = new int[steps + 1][maxPosition + 1];
    
    dp[0][0] = 1;
    
    for (int i = 1; i <= steps; i++) {
        for (int j = 0; j <= maxPosition; j++) {
            dp[i][j] = dp[i - 1][j];
            
            if (j > 0) {
                dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % mod;
            }
            
            if (j < maxPosition) {
                dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % mod; 
            }
        }
    }
    return dp[steps][0];
    }
}
