class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length - 1;
        int[] pairSum = new int[n];

        for(int i = 0; i < n; i++) {
            pairSum[i] = weights[i] + weights[i+1];
        }

        Arrays.sort(pairSum);
        long maxSum = 0;
        long minSum = 0;

        for(int i = 0; i < k-1; i++) {
            minSum += pairSum[i];
            maxSum += pairSum[n-i-1];
        }

        return maxSum - minSum;
    }
}
