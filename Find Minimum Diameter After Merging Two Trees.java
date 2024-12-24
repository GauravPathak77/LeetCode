class Solution {
    private void buildGraph(int[][] edges, List<Integer>[] graph, int nodes) {
        for (int i = 0; i < nodes; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            graph[src].add(dest);
            graph[dest].add(src);
        }
    }

    private int[] findFarthestNode(int start, List<Integer>[] graph) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];
        int[] dist = new int[graph.length];

        queue.add(start);
        visited[start] = true;

        int farthestNode = start;
        int maxDist = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : graph[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    dist[neighbor] = dist[node] + 1;
                    queue.add(neighbor);

                    if (dist[neighbor] > maxDist) {
                        maxDist = dist[neighbor];
                        farthestNode = neighbor;
                    }
                }
            }
        }

        return new int[]{farthestNode, maxDist};
    }

    private int findDiameter(List<Integer>[] graph) {
        int[] farthest = findFarthestNode(0, graph);
        int[] diameterInfo = findFarthestNode(farthest[0], graph);
        return diameterInfo[1];
    }

    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int n1 = edges1.length + 1;
        int n2 = edges2.length + 1;

        List<Integer>[] graph1 = new ArrayList[n1];
        List<Integer>[] graph2 = new ArrayList[n2];

        buildGraph(edges1, graph1, n1);
        buildGraph(edges2, graph2, n2);

        int d1 = findDiameter(graph1);
        int d2 = findDiameter(graph2);

        int combinedDiameter = (d1 + 1) / 2 + (d2 + 1) / 2 + 1;

        return Math.max(combinedDiameter, Math.max(d1, d2));
    }
}
