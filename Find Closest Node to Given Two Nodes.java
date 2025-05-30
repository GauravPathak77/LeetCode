class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];

        Arrays.fill(dist1, -1);8
        Arrays.fill(dist2, -1);

        dfs(edges, node1, dist1);
        dfs(edges, node2, dist2);

        int minDist = Integer.MAX_VALUE;
        int result = -1;

        for (int i = 0; i < n; i++) {
            if (dist1[i] != -1 && dist2[i] != -1) {
                int maxDist = Math.max(dist1[i], dist2[i]);
                if (maxDist < minDist) {
                    minDist = maxDist;
                    result = i;
                }
            }
        }

        return result;
    }

    private void dfs(int[] edges, int start, int[] dist) {
        int distance = 0;
        while (start != -1 && dist[start] == -1) {
            dist[start] = distance++;
            start = edges[start];
        }
    }
}
