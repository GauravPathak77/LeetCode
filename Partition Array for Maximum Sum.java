class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int curMax = 0, curSum = 0;

            for (int j = i; j >= Math.max(0, i - k + 1); j--) {
                curMax = Math.max(curMax, arr[j]);
                int cur = curMax * (i - j + 1) + dp[j];
                curSum = Math.max(curSum, cur);
            }
            dp[i + 1] = curSum;
        }

        return dp[n];
    }
}
