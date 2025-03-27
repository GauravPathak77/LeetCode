class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();

        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int dominant = -1, totalCount = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() * 2 > n) {
                dominant = entry.getKey();
                totalCount = entry.getValue();
                break;
            }
        }

        int leftCount = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) == dominant) {
                leftCount++;
            }

            int left = i + 1, right = n - left;
            int rightCount = totalCount - leftCount;

            if (leftCount * 2 > left && rightCount * 2 > right) {
                return i;
            }
        }

        return -1;
    }
}
