class Solution {
    public long continuousSubarrays(int[] nums) {
        int i = 0, n = nums.length;
        long ans = 0;

        int min = nums[0], max = nums[0];

        for(int j = 0; j < n; j++) {
            min = Math.min(min, nums[j]);
            max = Math.max(max, nums[j]);

            while(Math.abs(max - min) > 2) {
                i++;
                min = nums[i];
                max = nums[i];
                for (int k = i; k <= j; k++) {
                    min = Math.min(min, nums[k]);
                    max = Math.max(max, nums[k]);
                }
            }

            ans += (j - i + 1);
        }

        return ans;
    }
}
