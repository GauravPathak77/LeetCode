class Solution {
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        Map<Integer, Integer> islandSize = new HashMap<>();
        int index = 2;
        int maxIsland = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(grid, i, j, index);
                    islandSize.put(index, size);
                    maxIsland = Math.max(maxIsland, size);
                    index++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> seenIslands = new HashSet<>();
                    int newSize = 1;
                    
                    for (int[] dir : DIRECTIONS) {
                        int ni = i + dir[0], nj = j + dir[1];
                        if (ni >= 0 && nj >= 0 && ni < n && nj < n && grid[ni][nj] > 1) {
                            int islandIdx = grid[ni][nj];
                            if (!seenIslands.contains(islandIdx)) {
                                seenIslands.add(islandIdx);
                                newSize += islandSize.get(islandIdx);
                            }
                        }
                    }
                    maxIsland = Math.max(maxIsland, newSize);
                }
            }
        }
        
        return maxIsland;
    }
    
    private int dfs(int[][] grid, int i, int j, int index) {
        int n = grid.length;
        if (i < 0 || j < 0 || i >= n || j >= n || grid[i][j] != 1) return 0;
        
        grid[i][j] = index;
        int size = 1;
        
        for (int[] dir : DIRECTIONS) {
            size += dfs(grid, i + dir[0], j + dir[1], index);
        }
        
        return size;
    }
}
