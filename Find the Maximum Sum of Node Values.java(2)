class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        int n = nums.length;
        long[][] temp = new long[n][2];
        for (int i = 0; i < n; i++) {
            temp[i][0] = -1;
            temp[i][1] = -1;
        }

        return calculateMax(nums, n, k, 0, 1, temp);
    }

    private long calculateMax(int[] nums, int n, int k, int curInd, int isEven, long[][] temp) {
        if (curInd == n) {
            return isEven == 1 ? 0 : Long.MIN_VALUE;
        }
        if (temp[curInd][isEven] != -1) {
            return temp[curInd][isEven];
        }

        long noXor = nums[curInd] + calculateMax(nums, n, k, curInd + 1, isEven, temp);
        long withXor = (nums[curInd] ^ k) + calculateMax(nums, n, k, curInd + 1, 1 - isEven, temp);

        long mxPossible = Math.max(noXor, withXor);
        temp[curInd][isEven] = mxPossible;
        return mxPossible;
    }
}
