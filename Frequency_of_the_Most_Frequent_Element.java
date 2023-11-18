class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = 0;
        int ans = Integer.MIN_VALUE;
        long sum = nums[0];
        while(right < nums.length){
            if(nums[right]*(right-left+1) <= k+sum){
                ans = Math.max(ans, right-left+1);
                right++;
                if(right < nums.length) sum += nums[right];
            }else{
                sum -= nums[left];
                left++;
            }
        }
        return ans;
    }
}
