class Solution {
    public int sumSubarrayMins(int[] arr) {
        final int MOD = 1_000_000_007;
        int n = arr.length;
        long result = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            result = (result + (long) arr[i] * (i - left[i]) * (right[i] - i)) % MOD;
        }

        return (int) result;
    }
}
