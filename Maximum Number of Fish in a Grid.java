class Solution {
    public int solve(int i, int j, int m, int n, int[][] grid) {
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] <= 0) return 0;

        int val = grid[i][j];

        grid[i][j] = -1;

        int down = solve(i+1, j, m, n, grid);
        int right = solve(i, j+1, m, n, grid);
        int up = solve(i-1, j, m, n, grid);
        int left = solve(i, j-1, m, n, grid);

        return val + (down + right + up + left);
    }
    public int findMaxFish(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = Integer.MIN_VALUE;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                ans = Math.max(ans, solve(i, j, m, n, grid));
            }
        }
        return ans;
    }
}
