class Solution {
    public long gridGame(int[][] grid) {
        long firstSum = 0;
        long secondSum = 0;
        long ans = Long.MAX_VALUE;

        for(int num : grid[0]) {
            firstSum += num;
        }

        for(int col = 0; col < grid[0].length; col++) {
            firstSum -= grid[0][col];

            long maxRobot2 = Math.max(firstSum, secondSum);

            ans = Math.min(ans, maxRobot2);

            secondSum += grid[1][col];
        }

        return ans;
    }
}
