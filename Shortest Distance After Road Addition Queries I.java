class Solution {
    public class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public class Pair implements Comparable<Pair> {
        int n;
        int path;

        public Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p) {
            return this.path - p.path;
        }
    }

    private int dijkstra(ArrayList<Edge>[] graph, int src) {
        int[] dist = new int[graph.length];

        for(int i = 0; i < dist.length; i++) {
            if(i != src) dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] vis = new boolean[graph.length];

        pq.add(new Pair(src, 0));

        while(!pq.isEmpty()) {
            Pair curr = pq.poll();

            if(!vis[curr.n]) {
                vis[curr.n] = true;

                for(Edge e : graph[curr.n]) {
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if(dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        return dist[graph.length - 1];
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        ArrayList<Edge> graph[] = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            if(i < n-1) {
                graph[i].add(new Edge(i, i+1, 1));
            }
        }

        int[] ans = new int[queries.length];

        for(int i = 0; i < queries.length; i++) {
            int s = queries[i][0];
            int d = queries[i][1];
            graph[s].add(new Edge(s, d, 1));

            ans[i] = dijkstra(graph, 0);
        }

        return ans;
    }
}
