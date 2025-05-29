class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n=edges1.length+1;
        int m=edges2.length+1;

        List<List<Integer>> graph1=buildGraph(edges1, n);
        List<List<Integer>> graph2=buildGraph(edges2, m);

        int[] colorCount1=new int[2];
        int[] nodeColors1=new int[n];
        bfsColoring(graph1, colorCount1, nodeColors1);

        int[] colorCount2=new int[2];
        int[] nodeColors2=new int[m];
        bfsColoring(graph2, colorCount2, nodeColors2);

        int maxColorInTree2=Math.max(colorCount2[0], colorCount2[1]);

        int[] result=new int[n];
        for(int i=0;i<n;i++) {
            int c=nodeColors1[i];
            result[i]=colorCount1[c] + maxColorInTree2;
        }

        return result;
    }

    public List<List<Integer>> buildGraph(int[][] edges, int size) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<size;i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] edge:edges) {
            int u=edge[0], v=edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return graph;
    }

    public void bfsColoring(List<List<Integer>> graph, int[] colorCount, int[] nodeColors) {
        int n=graph.size();
        boolean[] visited=new boolean[n];
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0]=true;

        while(!queue.isEmpty()) {
            int[] curr=queue.poll();
            int node=curr[0], color=curr[1];
            nodeColors[node]=color;
            colorCount[color]++;

            for(int neighbor:graph.get(node)) {
                if(!visited[neighbor]) {
                    visited[neighbor]=true;
                    queue.offer(new int[]{neighbor, 1-color});
                }
            }
        }
    }
}
