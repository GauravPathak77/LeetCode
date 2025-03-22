class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        boolean[] vis = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                List<Integer> comp = new ArrayList<>();
                dfs(i, adj, vis, comp);
                if (isComplete(comp, adj)) count++;
            }
        }
        return count;
    }

    private void dfs(int node, List<List<Integer>> adj, boolean[] vis, List<Integer> comp) {
        vis[node] = true;
        comp.add(node);
        for (int nei : adj.get(node)) {
            if (!vis[nei]) dfs(nei, adj, vis, comp);
        }
    }

    private boolean isComplete(List<Integer> comp, List<List<Integer>> adj) {
        int size = comp.size();
        for (int node : comp) {
            if (adj.get(node).size() != size - 1) return false;
        }
        return true;
    }
}
