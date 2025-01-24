class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> reversedGraph = new ArrayList<>();
        int[] inDegree = new int[n];
        
        for (int i = 0; i < n; i++) {
            reversedGraph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n; i++) {
            for (int neighbor : graph[i]) {
                reversedGraph.get(neighbor).add(i);
                inDegree[i]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        List<Integer> safeNodes = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            safeNodes.add(node);
            for (int neighbor : reversedGraph.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        Collections.sort(safeNodes);
        return safeNodes;
    }
}
