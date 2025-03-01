class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        for(int i = 0; i < n-1; i++) {
            if(nums[i] == nums[i+1]) {
                nums[i] *= 2;
                nums[i+1] = 0;
            }
        }

        int i = 0, j = 0;
        while(i < n) {
            if(nums[i] != 0) {
                ans[j] = nums[i];
                j++;
            }

            i++;
        }

        return ans;
    }
}
