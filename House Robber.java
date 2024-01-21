class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return robUtil(nums, 0, dp);
    }
     private int robUtil(int nums[], int i, int dp[]) {
        if(i >= nums.length){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }

        int include = nums[i] + robUtil(nums, i + 2, dp);
        int exclude = robUtil(nums, i + 1, dp);
        
        return dp[i] = Math.max(include, exclude);
    }
}
