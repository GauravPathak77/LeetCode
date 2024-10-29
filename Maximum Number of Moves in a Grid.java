class Solution {
    private int solve(int row, int col, int[][] grid, int prev, int m, int n, int[][] memo) {

        if(row < 0 || row >= m || col >= n || grid[row][col] <= prev) return -1;

        if(memo[row][col] != -1) return memo[row][col];

        int first = 1 + solve(row-1, col+1, grid, grid[row][col], m, n, memo);

        int second = 1 + solve(row, col+1, grid, grid[row][col], m, n, memo);

        int third = 1 + solve(row+1, col+1, grid, grid[row][col], m, n, memo);

        return memo[row][col] = Math.max(first, Math.max(second, third));
    }
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxAns = 0;

        int[][] memo = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }

        for(int i=0; i<grid.length; i++) {
            maxAns = Math.max(maxAns, solve(i, 0, grid, 0, m, n, memo));
        }

        return maxAns;
    }
}
