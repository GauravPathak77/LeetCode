class Solution {
    public class Pair implements Comparable<Pair>{
        int row;
        int col;
        int time;

        public Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }

        @Override
        public int compareTo(Pair p) {
            return this.time - p.time;
        }
    }

    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int minimumTime(int[][] grid) {
        if(grid[0][1] > 1 && grid[1][0] > 1) return -1;

        int m = grid.length;
        int n = grid[0].length;

        int[][] dist = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = 0;

        boolean[][] vis = new boolean[m][n];
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0, 0));

        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            int r = curr.row;
            int c = curr.col;
            int time = curr.time;

            if(!vis[r][c]) {
                vis[r][c] = true;

                for(int[] dir : directions) {
                    int x = r + dir[0];
                    int y = c + dir[1];
                    int newTime = 0;

                    if(x < 0 || y < 0 || x >= m || y >= n) continue;

                    if(grid[x][y] <= time + 1) newTime = time + 1;
                    else {
                        if((grid[x][y] - time) % 2 == 0) newTime = grid[x][y] + 1;
                        else newTime = grid[x][y];
                    }

                    if(newTime < dist[x][y]) {
                        pq.add(new Pair(x, y, newTime));
                        dist[x][y] = newTime;
                    }
                }
            }
        }

        return dist[m-1][n-1];
    }
}
