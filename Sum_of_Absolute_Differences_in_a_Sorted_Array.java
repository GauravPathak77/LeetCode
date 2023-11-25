class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        int sum = 0;
        int prefix = 0;

        for(int i=0; i<n; i++){
            sum += nums[i];
        }

        for(int i=0; i<n; i++){
            ans[i] = (nums[i]*i - prefix) + ((sum - prefix-nums[i]) - nums[i]*(n-1-i));
            prefix += nums[i];
        }

        return ans;
    }
}
