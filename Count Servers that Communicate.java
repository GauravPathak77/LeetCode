class Solution {
    private boolean isCommunicate(int r, int c, int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            if(i != r && grid[i][c] == 1) return true;
        }

        for(int j = 0; j < grid[0].length; j++) {
            if(j != c && grid[r][j] == 1) return true;
        }

        return false;
    }

    public int countServers(int[][] grid) {
        int ans = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1 && isCommunicate(i, j, grid)) ans++;
            }
        }

        return ans;
    }
}
