class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans = 0;
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            int left = lowerBound(nums, i + 1, n - 1, lower - nums[i]);
            int right = upperBound(nums, i + 1, n - 1, upper - nums[i]);
            ans += right - left + 1;
        }

        return ans;
    }

    private int lowerBound(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private int upperBound(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;

    }
}
