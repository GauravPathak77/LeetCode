class Solution {
    private boolean solve(int idx, int s1, int s2, int[] nums, Boolean[][] memo) {
        if(s1 == s2) return true;
        if(idx == nums.length || s1 > s2) return false;

        if(memo[idx][s1] != null) return memo[idx][s1];

        boolean take = solve(idx+1, s1+nums[idx], s2-nums[idx], nums, memo);
        boolean notTake = solve(idx+1, s1, s2, nums, memo);

        return memo[idx][s1] = take || notTake;
    }
    public boolean canPartition(int[] nums) {
        int s1 = 0, s2 = 0;

        for(int num : nums) s2 += num; 
        if(s2 % 2 != 0) return false;

        int target = s2 / 2;
        Boolean[][] memo = new Boolean[nums.length][target + 1];

        return solve(0, s1, s2, nums, memo);
    }
}
