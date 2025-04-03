class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long ans = 0;
        long maxDiff = 0;
        long res = 0;
        
        for (int k = 0; k < n; k++) {
            ans = Math.max(ans, maxDiff * nums[k]);
            maxDiff = Math.max(maxDiff, res - nums[k]);
            res = Math.max(res, nums[k]);
        }
        
        return ans;
    }
}
