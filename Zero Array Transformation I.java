class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n+1];
        
        for(int i  = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            diff[l] = diff[l] - 1;
            if(r+1 < n) diff[r+1] = diff[r+1] + 1;
        }

        int temp = 0;
        for(int i = 0; i < n; i++) {
            temp = temp + diff[i];
            if(nums[i] != 0) {
                if(nums[i] + temp < 0) nums[i] = 0;
                else nums[i] = nums[i] + temp;
            }
        }

        for(int num : nums) {
            if(num != 0) return false;
        }

        return true;
    }
}
