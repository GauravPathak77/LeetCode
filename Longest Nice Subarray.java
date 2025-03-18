class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int bitMask = 0;
        int start = 0, end = 0;

        while(end < n) {
            if((bitMask & nums[end]) == 0) {
                bitMask = bitMask | nums[end];
                ans = Math.max(ans, end - start + 1);
                end++;
            } 
            else {
                bitMask = bitMask ^ nums[start];
                start++;
            } 
        }

        return ans;
    }
}
