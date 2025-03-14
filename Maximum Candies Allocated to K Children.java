class Solution {
    private boolean canDistr(int[] candies, int mid, long k) {
        int n = candies.length;

        for (int i = 0; i < n; i++) {
            k -= candies[i] / mid;

            if (k <= 0) {
                return true;
            }
        }

        return k <= 0;
    }

    public int maximumCandies(int[] candies, long k) {
        int n = candies.length;

        int maxC = 0;
        long total = 0;
        for (int i = 0; i < n; i++) {
            total += candies[i];
            maxC = Math.max(maxC, candies[i]);
        }

        if (total < k) {
            return 0;
        }

        int l = 1;
        int r = maxC;
        int result = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (canDistr(candies, mid, k)) {
                result = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return result;
    }
}
