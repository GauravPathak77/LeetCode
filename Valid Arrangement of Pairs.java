class Solution {
    Map<Integer, List<Integer>> adjList = new HashMap<>();
    List<Integer> eulerPath = new ArrayList<>();

    private void dfs(int src) {
        while(adjList.containsKey(src) && adjList.get(src).size() != 0) {
            int dest = adjList.get(src).remove(adjList.get(src).size()-1);
            dfs(dest);
        }
        eulerPath.add(src);
    }

    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, Integer> indeg = new HashMap<>();
        Map<Integer, Integer> outdeg = new HashMap<>();

        for(int[] pair : pairs) {
            int u = pair[0];
            int v = pair[1];
            adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            outdeg.put(u, outdeg.getOrDefault(u, 0) + 1);
            indeg.put(v, indeg.getOrDefault(v, 0) + 1);
        }

        int startNode = pairs[0][0];

        for(int node : adjList.keySet()) {
            if(outdeg.getOrDefault(node, 0) - indeg.getOrDefault(node, 0) == 1) {
                startNode = node;
                break;
            }
        }

        dfs(startNode);

        Collections.reverse(eulerPath);
        for(int val : eulerPath) {
            System.out.println(val);
        }

        int[][] ans = new int[pairs.length][pairs[0].length];

        for(int i = 0; i < eulerPath.size() - 1; i++) {
            ans[i][0] = eulerPath.get(i);
            ans[i][1] = eulerPath.get(i+1);
        }

        return ans;
    }
}
