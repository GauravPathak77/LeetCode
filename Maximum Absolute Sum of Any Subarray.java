class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int currMax = 0, maxSum = 0, currMin = 0, minSum = 0;

        for(int num : nums) {
            currMax = Math.max(currMax + num, num);
            maxSum = Math.max(maxSum, currMax);

            currMin = Math.min(currMin + num, num);
            minSum = Math.min(minSum, currMin);
        }

        return Math.max(maxSum, Math.abs(minSum));
    }
}
