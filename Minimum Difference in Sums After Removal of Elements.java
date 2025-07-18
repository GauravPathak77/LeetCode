class Solution {
    public long minimumDifference(int[] nums) {
        int n = nums.length / 3;
        int len = nums.length;

        long[] leftMaxSums = new long[len];
        long[] rightMinSums = new long[len];

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long rightSum = 0;
        for (int i = len - 1; i >= 0; i--) {
            minHeap.add(nums[i]);
            rightSum += nums[i];
            if (minHeap.size() > n) {
                rightSum -= minHeap.poll();
            }
            if (minHeap.size() == n) {
                rightMinSums[i] = rightSum;
            }
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long leftSum = 0;
        for (int i = 0; i < len; i++) {
            maxHeap.add(nums[i]);
            leftSum += nums[i];
            if (maxHeap.size() > n) {
                leftSum -= maxHeap.poll();
            }
            if (maxHeap.size() == n) {
                leftMaxSums[i] = leftSum;
            }
        }

        long minDiff = Long.MAX_VALUE;
        for (int i = n - 1; i < 2 * n; i++) {
            minDiff = Math.min(minDiff, leftMaxSums[i] - rightMinSums[i + 1]);
        }

        return minDiff;
    }
}
