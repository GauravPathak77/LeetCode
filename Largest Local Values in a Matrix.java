class Solution {
    public int[][] largestLocal(int[][] grid) {
        int nRows = grid.length;
        int nCols = grid[0].length;

        int[][] result = new int[nRows - 2][nCols - 2];

        for (int row = 0; row < nRows - 2; row++) {
            for (int col = 0; col < nCols - 2; col++) {
                result[row][col] = findLargest(grid, row, col);
            }
        }

        return result;
    }

    private int findLargest(int[][] grid, int row, int col) {
        int best = grid[row][col];
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                best = Math.max(best, grid[i][j]);
            }
        }
        return best;
    }
}
