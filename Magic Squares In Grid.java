class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows - 2; i++) {
            for (int j = 0; j < cols - 2; j++) {
                if (isMagic(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isMagic(int[][] grid, int row, int col) {
        int[] nums = new int[16];
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int val = grid[row + i][col + j];
                if (val < 1 || val > 9 || nums[val] != 0) {
                    return false;
                }
                nums[val] = 1;
            }
        }

        int sum = grid[row][col] + grid[row][col + 1] + grid[row][col + 2];
        return (sum == grid[row + 1][col] + grid[row + 1][col + 1] + grid[row + 1][col + 2]) &&
               (sum == grid[row + 2][col] + grid[row + 2][col + 1] + grid[row + 2][col + 2]) &&
               (sum == grid[row][col] + grid[row + 1][col] + grid[row + 2][col]) &&
               (sum == grid[row][col + 1] + grid[row + 1][col + 1] + grid[row + 2][col + 1]) &&
               (sum == grid[row][col + 2] + grid[row + 1][col + 2] + grid[row + 2][col + 2]) &&
               (sum == grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2]) &&
               (sum == grid[row][col + 2] + grid[row + 1][col + 1] + grid[row + 2][col]);
    }
}
