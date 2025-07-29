class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] rightMost = new int[32];

        for(int i = n - 1; i >= 0; i--) {
            for(int j = 0; j < 32; j++) {
                if((nums[i] & (1 << j)) != 0) {
                    rightMost[j] = i;
                }
            }

            int maxIdx = i;
            for(int j = 0; j < 32; j++) {
                maxIdx = Math.max(maxIdx, rightMost[j]);
            }

            ans[i] = maxIdx - i + 1;
        }

        return ans;
    }
}
