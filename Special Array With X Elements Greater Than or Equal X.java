class Solution {
    public int specialArray(int[] nums) {
        int n = nums.length;
        int[] freq = new int[n + 1];

        for (int i=0; i<nums.length; i++) {
            freq[Math.min(n, nums[i])]++;
        }

        int num = 0;
        for (int i = n; i>0; --i) {
            num += freq[i];
            if (i == num) {
                return i;
            }
        }
        
        return -1;
    }
}
