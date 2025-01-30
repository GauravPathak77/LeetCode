class Solution {
    public int magnificentSets(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int node = 1; node <= n; node++) {
            graph.put(node, new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        Map<Integer, List<Integer>> components = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        int component = 1;
        for (int node = 1; node <= n; node++) {
            if(visited.contains(node)) continue;
            visited.add(node);
            components.put(component, new ArrayList<>());
            dfsComponents(component++, node, graph, components, visited);    
        }
        int[] componentsMaxTravel = new int[component];
        int finalRes = 0;
        for(int comp = 1; comp < component; comp++) {
            for (int compNode : components.get(comp)) {
                
                int compRes = bfs(compNode, graph);
                if(compRes == -1) return -1;
                componentsMaxTravel[comp] = Math.max(componentsMaxTravel[comp], compRes);
            }
            finalRes += componentsMaxTravel[comp];
        }

        return finalRes;
        
    }

    private void dfsComponents(int component, int node, Map<Integer, List<Integer>> graph, Map<Integer, List<Integer>> components, Set<Integer> visited) {
        components.get(component).add(node);
        for (int neighbor : graph.get(node)) {
            if(visited.contains(neighbor)) continue;
            visited.add(neighbor);
            dfsComponents(component, neighbor, graph, components, visited);
        }
    }

    private int bfs(int node, Map<Integer, List<Integer>> graph) {
        int reach = 0;
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> curLevel = new HashSet<>();
        
        queue.offer(node);
        visited.add(node);
        
        while (!queue.isEmpty()) {
            int n = queue.size();
            Set<Integer> nextLevel = new HashSet<>();

            
            
            for (int i = 0; i < n; i++) {
                int curNode = queue.poll();

                for(int neighbor : graph.get(curNode)) {
                    if(curLevel.contains(neighbor)) return -1;
                    if(visited.contains(neighbor)) continue;
                    nextLevel.add(neighbor);
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }

            curLevel = nextLevel;
            reach++;
        }
        
        return reach;
    }
}
