class Solution {
    public int longestSubarray(int[] nums) {
        int maxVal = nums[0];

        for(int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        int currLength = 0;
        int ans = 0;

        for(int num : nums) {
            if(num == maxVal) {
                currLength++;
                ans = Math.max(ans, currLength);
            } else {
                currLength = 0;
            }
        }

        return ans;
    }
}
