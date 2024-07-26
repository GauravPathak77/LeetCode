class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE / 2);
            dist[i][i] = 0;
        }
        
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1], weight = edge[2];
            dist[from][to] = weight;
            dist[to][from] = weight;
        }
        
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        
        int minCity = -1;
        int minReachable = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            int reachable = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= distanceThreshold) {
                    reachable++;
                }
            }
            if (reachable < minReachable || (reachable == minReachable && i > minCity)) {
                minReachable = reachable;
                minCity = i;
            }
        }
        
        return minCity;
    }
}
