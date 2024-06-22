class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int oddCount = 0, result = 0;
        int[] prefixCounts = new int[nums.length + 1];
        prefixCounts[0] = 1;

        for (int i=0; i<nums.length; i++){
            int num = nums[i];
            if (num % 2 != 0) {
                oddCount++;
            }
            if (oddCount >= k) {
                result += prefixCounts[oddCount - k];
            }
            prefixCounts[oddCount]++;
        }

        return result;
    }
}
