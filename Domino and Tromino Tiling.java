class Solution {
    static int MOD = 1000000007;

    private int solve(int n, int[] memo) {
        if(n == 0 || n == 1) return 1;
        if(n == 2) return 2;

        if(memo[n] != -1) return memo[n];

        int fnm1 = solve(n - 1, memo);
        int fnm3 = solve(n - 3, memo);
        memo[n] = (2 * fnm1 % MOD + fnm3) % MOD;
        
        return memo[n];
    }
    public int numTilings(int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);

        return solve(n, memo);
    }
}
