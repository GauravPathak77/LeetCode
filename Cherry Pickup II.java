class Solution {
  public int cherryPickup(int[][] grid) {
    final int m = grid.length;       
    final int n = grid[0].length;   
    int[][][] dp = new int[m][n][n];  


    for (int[][] A : dp)
      Arrays.stream(A).forEach(B -> Arrays.fill(B, -1));

    return cherryPickupUtil(grid, 0, 0, n - 1, dp);
  }

  private int cherryPickupUtil(int[][] grid, int x, int y1, int y2, int[][][] dp) {
    if (x == grid.length)
      return 0;

    if (y1 < 0 || y1 == grid[0].length || y2 < 0 || y2 == grid[0].length)
      return 0;

    if (dp[x][y1][y2] != -1)
      return dp[x][y1][y2];

    final int currRow = grid[x][y1] + (y1 == y2 ? 0 : grid[x][y2]);

    for (int k = -1; k <= 1; ++k)
      for (int l = -1; l <= 1; ++l)
        dp[x][y1][y2] =
            Math.max(dp[x][y1][y2], currRow + cherryPickupUtil(grid, x + 1, y1 + k, y2 + l, dp));

    return dp[x][y1][y2];
  }
}
