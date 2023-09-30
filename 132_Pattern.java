class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }

        int n = nums.length;
        int[] minArray = new int[n];
        minArray[0] = nums[0];

        for (int i = 1; i < n; i++) {
            minArray[i] = Math.min(minArray[i - 1], nums[i]);
        }

        Stack<Integer> s = new Stack<>();

        for (int j = n - 1; j >= 0; j--) {
            if (nums[j] > minArray[j]) {
                while (!s.isEmpty() && s.peek() <= minArray[j]) {
                    s.pop();
                }
                if (!s.isEmpty() && s.peek() < nums[j]) {
                    return true;
                }
                s.push(nums[j]);
            }
        }

        return false;
    }
}
