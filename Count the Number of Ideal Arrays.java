class Solution {
    static final int MOD = 1_000_000_007;
    static int maxN = 10000;
    static long[] fact = new long[maxN + 1];
    static long[] invFact = new long[maxN + 1];

    static void precomputeFactorials() {
        fact[0] = 1;
        for (int i = 1; i <= maxN; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
        invFact[maxN] = modInverse(fact[maxN]);
        for (int i = maxN - 1; i >= 0; i--) {
            invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
        }
    }

    static long modInverse(long x) {
        return power(x, MOD - 2);
    }

    static long power(long x, long y) {
        long res = 1;
        x = x % MOD;
        while (y > 0) {
            if ((y & 1) == 1) res = (res * x) % MOD;
            x = (x * x) % MOD;
            y >>= 1;
        }
        return res;
    }

    static long nCr(int n, int r) {
        if (r > n || r < 0) return 0;
        return (((fact[n] * invFact[r]) % MOD) * invFact[n - r]) % MOD;
    }

    public int idealArrays(int n, int maxValue) {
        precomputeFactorials();

        int[][] dp = new int[maxValue + 1][15];
        for (int i = 1; i <= maxValue; i++) dp[i][1] = 1;

        int maxLen = 1;

        for (int len = 2; len <= 14; len++) {
            for (int i = 1; i <= maxValue; i++) {
                for (int j = 2 * i; j <= maxValue; j += i) {
                    dp[j][len] = (dp[j][len] + dp[i][len - 1]) % MOD;
                }
            }
            maxLen++;
        }

        long res = 0;
        for (int val = 1; val <= maxValue; val++) {
            for (int len = 1; len <= maxLen; len++) {
                long count = dp[val][len];
                if (count == 0) continue;
                res = (res + (count * nCr(n - 1, len - 1)) % MOD) % MOD;
            }
        }

        return (int) res;
    }
}
