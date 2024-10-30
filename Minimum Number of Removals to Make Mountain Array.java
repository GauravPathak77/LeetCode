public class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] leftDP = new int[n];
        int[] rightDP = new int[n];
        Arrays.fill(leftDP, 1);
        Arrays.fill(rightDP, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    leftDP[i] = Math.max(leftDP[i], leftDP[j] + 1);
                }
            }
        }
        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    rightDP[i] = Math.max(rightDP[i], rightDP[j] + 1);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (leftDP[i] != 1 && rightDP[i] != 1) {
                ans = Math.max(ans, leftDP[i] + rightDP[i]);
            }
        }
        
        return n - ans + 1;
    }
}
