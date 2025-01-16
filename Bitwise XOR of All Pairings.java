class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int xor1 = 0, xor2 = 0;

        for(int num : nums1) {
            xor1 ^= num;
        }
        for(int num : nums2) {
            xor2 ^= num;
        }

        int result = 0;

        if(nums2.length % 2 != 0) {
            result ^= xor1;
        }

        if(nums1.length % 2 != 0) {
            result ^= xor2;
        }

        return result;
    }
}
