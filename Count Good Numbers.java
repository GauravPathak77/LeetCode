class Solution {
    static final int MOD = 1000000007;

    private long modPow(long base, long exp, int mod) {
        long res = 1;

        base %= mod;

        while(exp > 0) {
            if((exp & 1) == 1) {
                res = (res * base) % mod;
            }

            base = (base * base) % mod;
            exp >>= 1;
        }

        return res;
    }

    public int countGoodNumbers(long n) {
        long evenPos = (n + 1) / 2;
        long oddPos = n / 2;

        long evenCh = modPow(5, evenPos, MOD);
        long oddCh = modPow(4, oddPos, MOD);

        return (int)((evenCh * oddCh) % MOD);

    }
}
