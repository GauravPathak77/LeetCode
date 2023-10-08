class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int dp[][] = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        
        return sub(nums1, nums2, 0, 0, dp);
    }
    
    private int sub(int[] nums1, int[] nums2, int i, int j, int[][] dp) {
        int n = nums1.length;
        int m = nums2.length;
        
        if (i == n || j == m) {
            return Integer.MIN_VALUE;
        }
        
        if (dp[i][j] != Integer.MIN_VALUE) {
            return dp[i][j];
        }
        
        dp[i][j] = Math.max(
            nums1[i] * nums2[j] + Math.max(sub(nums1, nums2, i + 1, j + 1, dp), 0),
            Math.max(sub(nums1, nums2, i + 1, j, dp), sub(nums1, nums2, i, j + 1, dp))
        );
        
        return dp[i][j];
    }
}
