class Solution {
    public int minOperations(int[] nums, int k) {
         int maxXOR = 0;
        for (int num : nums) {
            maxXOR ^= num;
        }

        int diff = maxXOR ^ k;
        if (diff == 0) {
            return 0;
        }

        int res = 0;
        int bitPos = 0;

        while (diff > 0) {
            if ((diff & 1) == 1) {
                res++;
            }
            diff >>= 1;
            bitPos++;
        }
        return res;
    }
}
