class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;

        int[][] ans = new int[m][n];
        for(int[] row : ans) {
            Arrays.fill(row, -1);
        }

        Queue<int[]> queue = new LinkedList<>();
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(isWater[i][j] == 1) {
                    ans[i][j] = 0;
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while(!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];

            for(int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if(newX >= 0 && newX < m && newY >= 0 && newY < n && ans[newX][newY] == -1) {
                    ans[newX][newY] = ans[x][y] + 1;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }

        return ans;
    }
}
