class Solution {
    private static final int MOD = 1000000007;

    private int solve(int num, int n, int x, int res, int[][] memo) {
        if (res == n) return 1;
        if (num > n || res > n) return 0;
        if (memo[num][res] != -1) return memo[num][res];

        int power = (int)Math.pow(num, x);
        int take = 0;
        if (power <= n) take = solve(num + 1, n, x, res + power, memo) % MOD;
        int notTake = solve(num + 1, n, x, res, memo) % MOD;

        return memo[num][res] = (take + notTake) % MOD;
    }
    public int numberOfWays(int n, int x) {
        int[][] memo = new int[n + 1][n + 1];
        for (int[] row : memo) Arrays.fill(row, -1);
        return solve(1, n, x, 0, memo);
    }
}
