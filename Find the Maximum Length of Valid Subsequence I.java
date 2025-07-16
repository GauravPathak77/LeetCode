class Solution {
    public int maximumLength(int[] nums) {
        int expParity = nums[0] % 2;
        int oddCount = 0, evenCount = 0, altCount = 0;

        for(int num : nums) {
            if(num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }

            if(num % 2 == expParity) {
                altCount++;
                expParity = 1 - expParity;
            }
        }

        return Math.max(altCount, Math.max(oddCount, evenCount));
    }
}
