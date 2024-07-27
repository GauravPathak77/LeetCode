class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int[][] graph = createGraph(original, changed, cost);
        optimizeGraph(graph);
        return findCost(graph, source, target);
    }
    public int[][] createGraph(char[] original, char[] changed, int[] cost) {
        int[][] graph = new int[26][26];
        for(int[] row : graph) {
            Arrays.fill(row, Integer.MAX_VALUE/2);
        }
        for(int i=0; i<26; i++) {
            graph[i][i] = 0;
        }
        for(int i=0; i<original.length; i++) {
            graph[original[i]-'a'][changed[i]-'a'] = Math.min(graph[original[i]-'a'][changed[i]-'a'], cost[i]);
        }
        return graph;
    }
    public void optimizeGraph(int[][] graph) {
        for(int j=0; j<26; j++) {
            for(int i=0; i<26; i++) {
                if(graph[i][j] < Integer.MAX_VALUE/2) {
                    for(int k=0; k<26; k++) {
                        if(graph[j][k] < Integer.MAX_VALUE/2) {
                            graph[i][k] = Math.min(graph[i][k], graph[i][j]+graph[j][k]);
                        }
                    }
                }
            }
        }
    }
    public long findCost(int[][] graph, String source, String target) {
        long minCost = 0;
        for(int i=0; i<source.length(); i++) {
            if(source.charAt(i)-'a' != target.charAt(i)-'a') {
                if(graph[source.charAt(i)-'a'][target.charAt(i)-'a'] == Integer.MAX_VALUE/2) {
                    return -1L;
                }
                minCost += graph[source.charAt(i)-'a'][target.charAt(i)-'a'];
            }
        }
        return minCost;
    }
}
