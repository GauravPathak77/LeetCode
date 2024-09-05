class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int totalSum = (n + m) * mean;

        int sumOfObservedRolls = 0;
        for (int roll : rolls) {
            sumOfObservedRolls += roll;
        }

        int missingSum = totalSum - sumOfObservedRolls;

        if (missingSum < n || missingSum > 6 * n) {
            return new int[0];
        }

        int[] result = new int[n];
        Arrays.fill(result, 1);
        missingSum -= n;

        int i = 0;
        while (missingSum > 0) {
            int add = Math.min(5, missingSum);
            result[i] += add;
            missingSum -= add;
            i++;
            if (i == n) i = 0;
        }

        return result;
    }
}
