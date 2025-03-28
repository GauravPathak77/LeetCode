class Solution {
    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length;
        int n = grid[0].length;
        int q = queries.length;
        int[] result = new int[q];

        int[][] sortedQ = new int[q][2];
        for (int i = 0; i < q; i++) {
            sortedQ[i][0] = queries[i];
            sortedQ[i][1] = i;
        }
        Arrays.sort(sortedQ, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        boolean[][] vis = new boolean[m][n];
        int points = 0;

        pq.add(new int[]{grid[0][0], 0, 0});
        vis[0][0] = true;

        for(int i = 0; i < q; i++) {
            int queryValue = sortedQ[i][0];
            int idx = sortedQ[i][1];

            while(!pq.isEmpty() && pq.peek()[0] < queryValue) {
                int[] top = pq.poll();
                int x = top[1], y = top[2];
                points++;

                for(int[] d : dir) {
                    int newRow = x + d[0];
                    int newCol = y + d[1];
                    if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !vis[newRow][newCol]) {
                        pq.add(new int[]{grid[newRow][newCol], newRow, newCol});
                        vis[newRow][newCol] = true;
                    }
                }
            }

            result[idx] = points;
        }

        return result;
    }
}
