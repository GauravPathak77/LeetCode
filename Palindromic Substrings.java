class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int ans = 0;

        if (n <= 0)
            return 0;

        boolean dp[][] = new boolean[n][n];

        for (int i = 0; i < n; ++i, ++ans)
            dp[i][i] = true;

        for (int i = 0; i < n - 1; ++i) {
            dp[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
            ans += (dp[i][i + 1] ? 1 : 0);
        }

        for (int k = 3; k <= n; ++k)
            for (int i = 0, j = i + k - 1; j < n; ++i, ++j) {
                dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                ans += (dp[i][j] ? 1 : 0);
            }

        return ans;
    }
}
