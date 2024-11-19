class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> st = new HashSet<>();
        long maxSum = 0;
        long currSum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            while (st.contains(nums[right])) {
                st.remove(nums[left]);
                currSum -= nums[left];
                left++;
            }

            st.add(nums[right]);
            currSum += nums[right];

            if (right - left + 1 == k) {
                maxSum = Math.max(maxSum, currSum);

                st.remove(nums[left]);
                currSum -= nums[left];
                left++;
            }
        }

        return maxSum;
    }
}
