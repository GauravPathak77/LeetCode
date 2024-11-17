class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefixSum = new long[n + 1];
        
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        
        Deque<Integer> deque = new LinkedList<>();
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {
            while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.peekFirst()] >= k) {
                minLength = Math.min(minLength, i - deque.pollFirst());
            }

            while (!deque.isEmpty() && prefixSum[i] <= prefixSum[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.offerLast(i);
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}
