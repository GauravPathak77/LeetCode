class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long ans = 0;

        for(int i = 0; i < n - 2; i++) {
            for(int j = i+1; j < n-1; j++) {
                for(int k = j+1; k < n; k++) {
                    long res = (long)(nums[i] - nums[j]) * nums[k];
                    ans = Math.max(ans, res);
                }
            }
        }

        return ans;
    }
}
