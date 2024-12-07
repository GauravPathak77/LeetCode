class Solution {
    private boolean isPossible(int[] nums, int maxOps, int target) {
        int totOps = 0;

        for(int num : nums) {
            totOps += (num / target);
            if(num % target == 0) totOps--;
            if(totOps > maxOps) return false;
        }

        return true;
    }
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1;
        int right = Integer.MIN_VALUE;

        for(int num : nums) {
            right = Math.max(right, num);
        }

        int result = right;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(isPossible(nums, maxOperations, mid)) {
                result = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return result;
    }
}
