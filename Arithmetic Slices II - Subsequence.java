class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int ans = 0;

        Map<Integer, Integer>[] dp = new HashMap[n];

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - (long) nums[j];

                if (diff >= Integer.MIN_VALUE && diff <= Integer.MAX_VALUE) {
                    int d = (int) diff;
                    int count = dp[j].getOrDefault(d, 0);
                    ans += count;
                    dp[i].put(d, dp[i].getOrDefault(d, 0) + count + 1);
                }
            }
        }

        return ans;
    }
}
