class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int ans = 1;
        int incSeq = 1;
        int decSeq = 1;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i-1]) {
                decSeq = 1;
                incSeq++;
                ans = Math.max(ans, incSeq);
            }
            else if(nums[i] < nums[i-1]) {
                incSeq = 1;
                decSeq++;
                ans = Math.max(ans, decSeq);
            } 
            else {
                incSeq = 1;
                decSeq = 1;
            }
        }

        return ans;
    }
}
