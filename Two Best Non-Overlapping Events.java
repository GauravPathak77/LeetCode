class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[1]));

        int n = events.length;
        int[] maxValues = new int[n];
        maxValues[0] = events[0][2];

        for (int i = 1; i < n; i++) {
            maxValues[i] = Math.max(maxValues[i - 1], events[i][2]);
        }

        int maxSum = 0;

        for (int i = 0; i < n; i++) {
            int currValue = events[i][2];

            int left = 0, right = i - 1, bestIdx = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (events[mid][1] < events[i][0]) {
                    bestIdx = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            if (bestIdx != -1) {
                currValue += maxValues[bestIdx];
            }

            maxSum = Math.max(maxSum, currValue);
        }

        return maxSum;
    }
}
