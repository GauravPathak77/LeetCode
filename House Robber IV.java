class Solution {
    private boolean isPossible(int mid, int k, int[] nums) {
        int house = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] <= mid) {
                house++;
                i++;
            }
        }

        return house >= k;
    }
    public int minCapability(int[] nums, int k) {
        int n = nums.length;
        int l = Integer.MAX_VALUE, r = Integer.MIN_VALUE;
        int ans = 0;

        for(int num : nums) {
            l = Math.min(l, num);
            r = Math.max(r, num);
        }

        while(l <= r) {
            int mid = (l + r) / 2;

            if(isPossible(mid, k, nums)) {
                ans = mid;
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }

        return ans;
    }
}
