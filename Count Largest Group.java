class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> digitSumCount = new HashMap<>();
        
        for (int i = 1; i <= n; i++) {
            int sum = digitSum(i);
            digitSumCount.put(sum, digitSumCount.getOrDefault(sum, 0) + 1);
        }

        int maxSize = 0;
        for (int count : digitSumCount.values()) {
            maxSize = Math.max(maxSize, count);
        }

        int result = 0;
        for (int count : digitSumCount.values()) {
            if (count == maxSize) {
                result++;
            }
        }

        return result;
    }

    private int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
