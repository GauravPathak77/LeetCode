class Solution {
    public int waysToSplitArray(int[] nums) {
        int ans = 0;
        long totSum = 0, leftSum = 0;

        for(int num : nums) totSum += num;

        for(int i = 0; i < nums.length-1; i++) {
            leftSum += nums[i];
            long rightSum = totSum - leftSum;
            if(leftSum >= rightSum) ans++;
        }

        return ans;
    }
}
