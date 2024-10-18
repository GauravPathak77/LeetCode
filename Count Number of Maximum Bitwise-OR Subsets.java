class Solution {
    public int countMaxOrSubsets(int[] nums) {
         int maxOr = 0;
        // Calculate the maximum possible bitwise OR of the array
        for (int num : nums) {
            maxOr |= num;
        }
        
        return countSubsetsWithMaxOr(nums, maxOr);
    }
    
    private int countSubsetsWithMaxOr(int[] nums, int maxOr) {
        int count = 0;
        int n = nums.length;
        
        for (int mask = 1; mask < (1 << n); mask++) {
            int currentOr = 0;
            
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    currentOr |= nums[i];
                }
            }
            
            if (currentOr == maxOr) {
                count++;
            }
        }
        
        return count;
    }
}
