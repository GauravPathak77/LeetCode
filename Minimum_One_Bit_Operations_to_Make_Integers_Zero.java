class Solution {
    public int minimumOneBitOperations(int n) {
        int bit = 1;
        int ans = 0;
        while (n > 0) {
            ans += n ^ (n - 1) * bit;
            bit = -1 * bit;
            n &= n - 1;
        }

        return Math.abs(ans);
    }
}
