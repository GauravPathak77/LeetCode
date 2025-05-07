class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.add(new int[]{0, 0, 0});        

        int[][] minTime = new int[n][m];
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                minTime[i][j] = Integer.MAX_VALUE;
            }
        }
        minTime[0][0] = 0;
                
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currTime = curr[0];
            int row = curr[1];
            int col = curr[2];

            if (currTime <= minTime[row][col]) {
                for(int i = 0; i < directions.length; i++) {
                    int currRow = row + directions[i][0];
                    int currCol = col + directions[i][1];
                    
                    if ((currRow >= 0 && currRow < n) && (currCol >= 0 && currCol < m)) {
                        int time = 1 + Math.max(moveTime[currRow][currCol], currTime);
                        
                        if (minTime[currRow][currCol] > time) {
                            minTime[currRow][currCol] = time;
                            pq.add(new int[]{time, currRow, currCol});
                    }
                }
            }
            }
        }
        
        return minTime[n-1][m-1];
    }
}
