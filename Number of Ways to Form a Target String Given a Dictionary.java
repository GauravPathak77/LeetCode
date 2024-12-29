class Solution {
    private static final int MOD = 1000000007;

    private int solve(int i, int j, int m, int k, long[][] freq, String target, int[][] memo) {
        if (i == m) return 1;
        if (j == k) return 0;

        if (memo[i][j] != -1) return memo[i][j];

        int take = 0;
        if (freq[target.charAt(i) - 'a'][j] > 0) {
            take = (int) (freq[target.charAt(i) - 'a'][j] * solve(i + 1, j + 1, m, k, freq, target, memo) % MOD);
        }

        int notTake = solve(i, j + 1, m, k, freq, target, memo);

        return memo[i][j] = (take + notTake) % MOD;
    }

    public int numWays(String[] words, String target) {
        int k = words[0].length();
        int m = target.length();

        long[][] freq = new long[26][k];
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                freq[ch - 'a'][i]++;
            }
        }

        int[][] memo = new int[m][k];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return solve(0, 0, m, k, freq, target, memo);
    }
}
