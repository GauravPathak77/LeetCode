class Solution {
    int ans = 0;
    private int solve(int n, int sum, int[] nums, int target) {
        if(n < 0) {
            if(sum == target) return 1;
            return 0;
        }

        int take = solve(n-1, sum - nums[n], nums, target);
        int notTake = solve(n-1, sum + nums[n], nums, target); 
        return take + notTake;
    }

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        return solve(nums.length-1, 0, nums, target);
    }
}
