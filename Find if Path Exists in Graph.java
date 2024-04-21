class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] vis = new boolean[n];
        List<Integer>[] graph = new ArrayList[n];

        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }
        
        return dfs(graph, vis, source, destination);
    }

    public boolean dfs(List<Integer>[] graph, boolean[] vis, int curr, int dest){
        if(curr == dest){
            return true;
        }
        
        vis[curr] = true;
        for(int i=0; i<graph[curr].size(); i++){
            Integer e = graph[curr].get(i);
            if(!vis[e]){
                if(dfs(graph, vis, e, dest)){
                    return true;
                }
            }
        }
        return false;
    }
}
