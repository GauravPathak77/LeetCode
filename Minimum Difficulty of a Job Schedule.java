class Solution {
    int n;
    int[][] dp;
    public int minDifficulty(int[] jobDifficulty, int d) {
        n = jobDifficulty.length;
        if(n < d) return -1;

        dp = new int[n][d + 1];
        for(int[] row : dp) Arrays.fill(row, -1);

        return helper(d, 0, jobDifficulty);
    }

    private int helper(int d, int i, int[] jobDifficulty){
        if(d == 0 && i == n) return 0;
        if(d == 0 || i == n) return Integer.MAX_VALUE;
        if(dp[i][d] != -1) return dp[i][d];

        int max = jobDifficulty[i];
        int min = Integer.MAX_VALUE;
        for(int j = i; j < n; ++j){
            max = Math.max(max, jobDifficulty[j]);
            int future = helper(d - 1, j + 1, jobDifficulty);
            if(future != Integer.MAX_VALUE)
                min = Math.min(min, future + max);
        }

        return dp[i][d] = min;
    }
}
