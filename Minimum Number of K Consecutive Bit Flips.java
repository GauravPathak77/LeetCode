class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int flip = 0;
        int[] flipMark = new int[n];

        for (int i = 0; i < n; i++) {
            if (i >= k) {
                flip ^= flipMark[i - k];
            }

            if (nums[i] == flip) {
                if (i + k > n) {
                    return -1;
                }

                ans++;
                flip ^= 1;
                flipMark[i] = 1;
            }
        }
        return ans;
    }
}
