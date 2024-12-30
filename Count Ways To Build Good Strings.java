class Solution {
    private int mod = 1000000007;
    private int solve(int size, int low, int high, int zero, int one, int[] memo) {
        if(size > high) return 0;

        if(memo[size] != -1) return memo[size];

        int count = (size >= low) ? 1 : 0;

        count = (count + solve(size + zero, low, high, zero, one, memo)) % mod;
        count = (count + solve(size + one, low, high, zero, one, memo)) % mod;

        return memo[size] = count;
    }
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] memo = new int[high + 1];
        Arrays.fill(memo, -1);
        return solve(0, low, high, zero, one, memo);
    }
}
