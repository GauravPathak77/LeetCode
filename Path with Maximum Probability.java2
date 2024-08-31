class Solution {
    public class Edge {
        int src;
        int dest;
        double prob;
        public Edge(int src, int dest, double prob) {
            this.src = src;
            this.dest = dest;
            this.prob = prob;
        }
    }

    public class Pair implements Comparable<Pair> {
        int n;
        double pathProb;
        public Pair(int n, double pathProb) {
            this.n = n;
            this.pathProb = pathProb;
        }
        @Override
        public int compareTo(Pair p) {
            return Double.compare(p.pathProb, this.pathProb);
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<Edge> graph[] = new ArrayList[n];
        
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int src = edge[0];
            int dest = edge[1];
            double prob = succProb[i];
            graph[src].add(new Edge(src, dest, prob));
            graph[dest].add(new Edge(dest, src, prob));
        }

        return dijkstra(graph, start_node, end_node, n);
    }

    public double dijkstra(ArrayList<Edge>[] graph, int src, int end_node, int n) {
        double[] dist = new double[n];
        Arrays.fill(dist, 0.0);
        dist[src] = 1.0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 1.0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            if (curr.n == end_node) {
                return curr.pathProb;
            }
            
            for (Edge e : graph[curr.n]) {
                int next = e.dest;
                double newProb = curr.pathProb * e.prob;
                if (newProb > dist[next]) {
                    dist[next] = newProb;
                    pq.add(new Pair(next, newProb));
                }
            }
        }

        return 0.0;
    }
}
