class Solution {
    public class Pair implements Comparable<Pair>{
        int[] node;
        int path;

        public Pair(int[] node, int path) {
            this.node = node;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p) {
            return this.path - p.path;
        }
    }

    private int dijkstra(int[][] graph, int[] src) {
        int m = graph.length;
        int n = graph[0].length;
        int[][] dist = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[src[0]][src[1]] = 0;

        boolean[][] vis = new boolean[m][n];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(new int[]{0, 0}, 0));

        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int x = curr.node[0];
            int y = curr.node[1];

            if (!vis[x][y]) {
                vis[x][y] = true;

                for (int[] dir : directions) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];

                    if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                        int wt = graph[nx][ny];
                        if (dist[x][y] + wt < dist[nx][ny]) {
                            dist[nx][ny] = dist[x][y] + wt;
                            pq.add(new Pair(new int[]{nx, ny}, dist[nx][ny]));
                        }
                    }
                }
            }
        }

        return dist[m - 1][n - 1];
    }

    public int minimumObstacles(int[][] grid) {
        return dijkstra(grid, new int[]{0, 0});
    }
}
