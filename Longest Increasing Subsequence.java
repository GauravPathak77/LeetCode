class Solution {
    int dp[][];
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n][n+1];
        return lengthLISUtil(0, -1, nums);
    }

    public int lengthLISUtil(int idx, int prev_idx, int nums[]){
        int n = nums.length;
        if(idx == n){
            return 0;
        }

        if(dp[idx][prev_idx+1] != 0) return dp[idx][prev_idx+1];
        int len = lengthLISUtil(idx+1, prev_idx, nums);
        if(prev_idx == -1 || nums[idx] > nums[prev_idx]){
            len = Math.max(len, 1 + lengthLISUtil(idx+1, idx, nums));
        }

        return dp[idx][prev_idx+1] = len;
    }
}
