class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        long mod = (long) Math.pow(10, 9) + 7;

        long[] prev = new long[target + 1];
        long[] curr = new long[target + 1];

        prev[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                long ans = 0;
                for (int x = 1; x <= k; x++) {
                    if (j - x >= 0) {
                        ans += prev[j - x] % mod;
                    }
                }
                curr[j] = ans;
            }
            prev = curr.clone();
        }
        return (int) (prev[target] % mod);
    }
}
