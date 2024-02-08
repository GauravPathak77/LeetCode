class Solution {
    int[] dp;

    public int numSquares(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(n);
    }

    public int solve(int n) {
        if(n == 0) return 0;
        if(n < 0) return Integer.MAX_VALUE;
        if(dp[n] != -1) return dp[n];
        int ans = Integer.MAX_VALUE;

        for(int i=1; i*i<=n; i++) {
            ans = Math.min(ans, 1 + solve(n-(i*i)));
        }
        
        return dp[n] = ans;
    }
}
