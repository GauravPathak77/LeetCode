class Solution {
    private boolean topologicalSort(int k, List<List<Integer>> graph, int[] result) {
        int[] indegree = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            for (int neighbor : graph.get(i)) {
                indegree[neighbor]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        int index = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result[index++] = node;

            for (int neighbor : graph.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return index == k;
    }

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<List<Integer>> rowGraph = new ArrayList<>();
        List<List<Integer>> colGraph = new ArrayList<>();

        for (int i = 0; i <= k; i++) {
            rowGraph.add(new ArrayList<>());
            colGraph.add(new ArrayList<>());
        }

        for (int[] condition : rowConditions) {
            rowGraph.get(condition[0]).add(condition[1]);
        }

        for (int[] condition : colConditions) {
            colGraph.get(condition[0]).add(condition[1]);
        }

        int[] rowOrder = new int[k];
        int[] colOrder = new int[k];

        if (!topologicalSort(k, rowGraph, rowOrder) || !topologicalSort(k, colGraph, colOrder)) {
            return new int[0][0];
        }

        int[][] matrix = new int[k][k];
        int[] rowPosition = new int[k + 1];
        int[] colPosition = new int[k + 1];

        for (int i = 0; i < k; i++) {
            rowPosition[rowOrder[i]] = i;
            colPosition[colOrder[i]] = i;
        }

        for (int i = 1; i <= k; i++) {
            matrix[rowPosition[i]][colPosition[i]] = i;
        }

        return matrix;
    }
}
