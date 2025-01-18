class Solution {
    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        boolean[][] visited = new boolean[m][n];

        pq.offer(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int cost = current[0];
            int row = current[1];
            int col = current[2];

            if (row == m - 1 && col == n - 1) {
                return cost;
            }

            if (visited[row][col]) continue;
            visited[row][col] = true;

            for (int i = 0; i < 4; i++) {
                int newRow = row + DIRECTIONS[i][0];
                int newCol = col + DIRECTIONS[i][1];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !visited[newRow][newCol]) {
                    int newCost = cost + (grid[row][col] == i + 1 ? 0 : 1);
                    pq.offer(new int[]{newCost, newRow, newCol});
                }
            }
        }

        return -1;
    }
}
