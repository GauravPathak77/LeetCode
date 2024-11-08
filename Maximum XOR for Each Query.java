class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] ans = new int[n];
        int maxBit = (int)Math.pow(2, maximumBit) - 1;
        int totXor = 0;

        for(int num : nums) {
            totXor = totXor ^ num;
        }

        for(int i = 0; i < n; i++) {
            ans[i] = totXor ^ maxBit;
            totXor = totXor ^ nums[n-i-1];
        }

        return ans;
    }
}
