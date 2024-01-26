class Solution {
     private static final int MOD = 1000000007;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[m][n][maxMove + 1];
        for (int[][] arr : dp) {
            for (int[] subArr : arr) {
                Arrays.fill(subArr, -1);
            }
        }

        return findPathsUtil(m, n,  maxMove, startRow, startColumn, dp);
    }

    private int findPathsUtil(int m, int n, int moves, int row, int col, int[][][] dp) {
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return 1;
        }

        if (moves == 0) {
            return 0;
        }

        if (dp[row][col][moves] != -1) {
            return dp[row][col][moves];
        }

        int ans = 0;
        ans = (ans + findPathsUtil(m, n, moves - 1, row - 1, col, dp)) % MOD;
        ans = (ans + findPathsUtil(m, n, moves - 1, row + 1, col, dp)) % MOD;
        ans = (ans + findPathsUtil(m, n, moves - 1, row, col - 1, dp)) % MOD;
        ans = (ans + findPathsUtil(m, n, moves - 1, row, col + 1, dp)) % MOD;

        dp[row][col][moves] = ans;

        return ans;
    }
}
