class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
       int m = grid1.length, n = grid1[0].length;
        int subIslandsCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    if (dfs(grid1, grid2, i, j)) {
                        subIslandsCount++;
                    }
                }
            }
        }
        return subIslandsCount;
    }

    private boolean dfs(int[][] grid1, int[][] grid2, int i, int j) {
        int m = grid1.length, n = grid1[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n || grid2[i][j] == 0) {
            return true;
        }

        grid2[i][j] = 0;

        boolean isSubIsland = grid1[i][j] == 1;

        isSubIsland &= dfs(grid1, grid2, i + 1, j);
        isSubIsland &= dfs(grid1, grid2, i - 1, j);
        isSubIsland &= dfs(grid1, grid2, i, j + 1);
        isSubIsland &= dfs(grid1, grid2, i, j - 1);

        return isSubIsland; 
    }
}
