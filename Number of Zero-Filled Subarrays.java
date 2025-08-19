class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0;
        long ans = 0;

        for (int num : nums) {
            if (num == 0) {
                ans++;
                count += ans;
            } else {
                ans = 0;
            }
        }

        return count;
    }
}
