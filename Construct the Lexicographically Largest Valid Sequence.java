class Solution {
    private boolean solve(int[] result, boolean[] used, int idx, int n) {
        if (idx == result.length) return true;

        if (result[idx] != 0) return solve(result, used, idx + 1, n);

        for (int i = n; i >= 1; i--) {
            if (used[i]) continue;

            if (i == 1 || (idx + i < result.length && result[idx + i] == 0)) {
                result[idx] = i;
                if (i != 1) result[idx + i] = i;
                used[i] = true;

                if (solve(result, used, idx + 1, n)) return true;

                result[idx] = 0;
                if (i != 1) result[idx + i] = 0;
                used[i] = false;
            }
        }
        return false;
    }

    public int[] constructDistancedSequence(int n) {
        int size = 2 * n - 1;
        int[] result = new int[size];
        boolean[] used = new boolean[n + 1];

        solve(result, used, 0, n);
        return result;
    }
}
