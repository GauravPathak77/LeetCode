class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int maxFruits = 0;
        int left = 0;
        int totalFruits = 0;

        for(int right = 0; right < n; right++) {
            totalFruits += fruits[right][1];

            while(left <= right && !canReach(fruits, left, right, startPos, k)) {
                totalFruits -= fruits[left][1];
                left++;
            }

            maxFruits = Math.max(maxFruits, totalFruits);
        }

        return maxFruits;
    }

    private boolean canReach(int[][] fruits, int left, int right, int startPos, int k) {
        int leftPos = fruits[left][0];
        int rightPos = fruits[right][0];

        int option1 = Math.abs(startPos - leftPos) + (rightPos - leftPos);
        int option2 = Math.abs(startPos - rightPos) + (rightPos - leftPos);

        return Math.min(option1, option2) <= k;
    }
}
