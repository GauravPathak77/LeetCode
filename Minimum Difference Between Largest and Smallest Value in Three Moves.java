class Solution {
    public int minDifference(int[] nums) {
        if(nums.length <= 4){
            return 0;
        }

        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        int idx = 0;

        while(idx <= 3){
            ans = Math.min(ans, nums[nums.length-1-idx] - nums[3-idx]);
            idx++;
        }

        return ans;
    }
}
