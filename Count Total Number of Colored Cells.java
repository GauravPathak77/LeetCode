class Solution {
    private long solve(int n, long[] memo) {
        if(n == 1) return 1;
        if(memo[n] != 0) return memo[n];

        memo[n] = 4*(n-1) + solve(n-1, memo);
        return memo[n];
    }
    public long coloredCells(int n) {
        long[] memo = new long[n+1];
        return solve(n, memo);
    }
}
