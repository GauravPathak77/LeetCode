class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>(n);
        List<Set<Integer>> ancestors = new ArrayList<>(n);
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            ancestors.add(new HashSet<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int src = edges[i][0];
            int dest = edges[i][1];
            graph.get(src).add(dest);
        }

        for (int i = 0; i < n; i++) {
            dfs(i, i, graph, ancestors);
        }

        List<List<Integer>> result = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            List<Integer> sortedAncestors = new ArrayList<>(ancestors.get(i));
            Collections.sort(sortedAncestors);
            result.add(sortedAncestors);
        }

        return result;
    }

    private void dfs(int start, int node, List<List<Integer>> graph, List<Set<Integer>> ancestors) {
        for (int neighbor : graph.get(node)) {
            if (ancestors.get(neighbor).add(start)) {
                dfs(start, neighbor, graph, ancestors);
            }
        }
    }
}
