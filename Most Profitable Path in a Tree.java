class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        List<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        
        for(int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        int[] bobTime = new int[n];
        Arrays.fill(bobTime, Integer.MAX_VALUE);
        
        dfsBob(graph, bob, -1, 0, bobTime);
        
        return dfsAlice(graph, 0, -1, 0, 0, bobTime, amount);
    }
    
    private boolean dfsBob(List<Integer>[] graph, int node, int parent, int time, int[] bobTime) {
        bobTime[node] = time;
        if(node == 0) return true;
        
        for(int neighbor : graph[node]) {
            if(neighbor == parent) continue;
            if(dfsBob(graph, neighbor, node, time + 1, bobTime)) return true;
        }
        
        bobTime[node] = Integer.MAX_VALUE;
        return false;
    }
    
    private int dfsAlice(List<Integer>[] graph, int node, int parent, int time, int currentSum, int[] bobTime, int[] amount) {
        if(time < bobTime[node]) {
            currentSum += amount[node];
        } else if(time == bobTime[node]) {
            currentSum += amount[node] / 2;
        }
        
        int maxIncome = Integer.MIN_VALUE;
        boolean isLeaf = true;
        
        for(int neighbor : graph[node]) {
            if(neighbor == parent) continue;
            isLeaf = false;
            maxIncome = Math.max(maxIncome, dfsAlice(graph, neighbor, node, time + 1, currentSum, bobTime, amount));
        }
        
        return isLeaf ? currentSum : maxIncome;
    }
}
