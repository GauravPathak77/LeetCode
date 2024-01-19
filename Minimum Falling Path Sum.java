class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if (matrix.length == 1) {
            return matrix[0][0];
        }
        int[][] dp = Arrays.copyOf(matrix, matrix.length); 
        for (int i = matrix.length - 2; i >= 0; i--) {
            for (int j = 0; j < matrix.length; j++) {
                int minPath = dp[i + 1][j];
                if (j > 0) {
                    minPath = Math.min(minPath, dp[i + 1][j - 1]);
                }
                if (j < matrix.length - 1) {
                    minPath = Math.min(minPath, dp[i + 1][j + 1]);
                }
                dp[i][j] += minPath;
            }
        }

        int result = Integer.MAX_VALUE;
        for (int num : dp[0]) {
            result = Math.min(result, num);
        }
        return result;
    }
}
