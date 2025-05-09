class Solution {
    static final int M = 1_000_000_007;
    int[][][] dp;
    int[] cnt = new int[10], leftS = new int[10], leftC = new int[10];
    long[] r1 = new long[11];
    int[][] cb = new int[81][81];

    void pascal() {
        for (int i = 0; i <= 80; i++) {
            cb[i][0] = cb[i][i] = 1;
            for (int j = 1; j < i; j++)
                cb[i][j] = (cb[i - 1][j - 1] + cb[i - 1][j]) % M;
        }
    }

    long dfs(int i, int s, int c) {
        if (s == 0 && c == 0) return r1[i];
        if (i == 10 || s > leftS[i] || c > leftC[i]) return 0;
        if (dp[i][s][c] != -1) return dp[i][s][c];
        long res = 0;
        int a = s;
        for (int x = 0, y = cnt[i]; x <= cnt[i] && a >= 0 && c >= x; x++, y--, a -= i) {
            if (y > leftC[i] - c) continue;
            long b = dfs(i + 1, a, c - x) * cb[c][x] % M;
            res = (res + b * cb[leftC[i] - c][y]) % M;
        }
        return dp[i][s][c] = (int) res;
    }

    public int countBalancedPermutations(String num) {
        int n = num.length(), s = 0, ls = 0, lc = 0;
        for (char ch : num.toCharArray()) {
            cnt[ch - '0']++;
            s += ch - '0';
        }
        if ((s & 1) != 0) return 0;
        pascal();
        r1[10] = 1;
        for (int i = 9; i >= 0; i--) {
            ls += i * cnt[i];
            lc += cnt[i];
            leftS[i] = ls;
            leftC[i] = lc;
            r1[i] = r1[i + 1] * cb[leftC[i]][cnt[i]] % M;
        }
        dp = new int[10][361][41];
        for (int[][] mat : dp)
            for (int[] row : mat)
                Arrays.fill(row, -1);
        return (int) dfs(0, s >> 1, n >> 1);
    }
}
