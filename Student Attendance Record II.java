class Solution {
    private static final int MOD = 1000000007;
    private Integer[][][] memo;
    public int checkRecord(int n) {
        memo = new Integer[n + 1][2][3];
        return helper(n, 0, 0);
    }
    private int helper(int n, int cntA, int concL) {
        if (n == 0) {
            return 1;
        }
        if (memo[n][cntA][concL] != null) {
            return memo[n][cntA][concL];
        }
        int result = 0;
        result = (result + helper(n - 1, cntA, 0)) % MOD;
        if (cntA == 0) {
            result = (result + helper(n - 1, cntA + 1, 0)) % MOD;
        }
        if (concL < 2) {
            result = (result + helper(n - 1, cntA, concL + 1)) % MOD;
        }
        memo[n][cntA][concL] = result;
        return result;
    }
}
