class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        
        int[][] dp = new int[k][n];
        for(int i = 0; i < k; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = 1;
            }
        }

        int ans = 1;

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                int mod = (nums[j] + nums[i]) % k;
                dp[mod][i] = Math.max(dp[mod][i], 1 + dp[mod][j]);
                ans = Math.max(ans, dp[mod][i]);
            }
        }

        return ans;
    }
}
