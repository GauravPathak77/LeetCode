class Solution {
    static final int MOD = 1_000_000_007;
    static int m, n;

    public int colorTheGrid(int m, int n) {
        this.m = m;
        this.n = n;
        List<int[]> validCols = new ArrayList<>();
        generateValidColumns(new int[m], 0, validCols);

        Map<String, Integer> codeToIndex = new HashMap<>();
        for (int i = 0; i < validCols.size(); i++) {
            codeToIndex.put(Arrays.toString(validCols.get(i)), i);
        }

        int[][] canFollow = new int[validCols.size()][validCols.size()];
        for (int i = 0; i < validCols.size(); i++) {
            for (int j = 0; j < validCols.size(); j++) {
                if (isValidTransition(validCols.get(i), validCols.get(j))) {
                    canFollow[i][j] = 1;
                }
            }
        }

        long[] dp = new long[validCols.size()];
        Arrays.fill(dp, 1);

        for (int col = 1; col < n; col++) {
            long[] newDp = new long[validCols.size()];
            for (int i = 0; i < validCols.size(); i++) {
                for (int j = 0; j < validCols.size(); j++) {
                    if (canFollow[i][j] == 1) {
                        newDp[i] = (newDp[i] + dp[j]) % MOD;
                    }
                }
            }
            dp = newDp;
        }

        long result = 0;
        for (long x : dp) {
            result = (result + x) % MOD;
        }
        return (int) result;
    }

    private void generateValidColumns(int[] col, int pos, List<int[]> res) {
        if (pos == m) {
            res.add(col.clone());
            return;
        }
        for (int color = 0; color < 3; color++) {
            if (pos > 0 && col[pos - 1] == color) continue;
            col[pos] = color;
            generateValidColumns(col, pos + 1, res);
        }
    }

    private boolean isValidTransition(int[] col1, int[] col2) {
        for (int i = 0; i < m; i++) {
            if (col1[i] == col2[i]) return false;
        }
        return true;
    }
}
