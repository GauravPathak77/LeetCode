class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        int[][] dp = new int[n][n];
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            indexMap.put(arr[i], i);
        }

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                int needed = arr[j] - arr[i];
                
                if (indexMap.containsKey(needed) && indexMap.get(needed) < i) {
                    int k = indexMap.get(needed);
                    dp[i][j] = dp[k][i] + 1;
                } else {
                    dp[i][j] = 2;
                }
                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }

        return maxLen > 2 ? maxLen : 0;
    }
}
