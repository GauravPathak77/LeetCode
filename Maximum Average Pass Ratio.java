class Solution {
    class Pair implements Comparable<Pair> {
        int pass;
        int tot;
        double delta;

        Pair(int pass, int tot, double delta) {
            this.pass = pass;
            this.tot = tot;
            this.delta = delta;
        }

        @Override
        public int compareTo(Pair p) {
            return Double.compare(p.delta, this.delta);
        }
    }
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int[] c : classes) {
            int pass = c[0];
            int total = c[1];
            double ratio = (double) pass / total;
            double newRatio = (double) (pass + 1) / (total + 1);
            double delta = newRatio - ratio;
            pq.add(new Pair(pass, total, delta));
        }

        while(extraStudents-- > 0) {
            Pair p = pq.poll();
            int pass = p.pass + 1;
            int total = p.tot + 1;

            double ratio = (double) pass / total;
            double newRatio = (double) (pass + 1) / (total + 1);
            double delta = newRatio - ratio;
            pq.add(new Pair(pass, total, delta));
        }

        double ans = 0;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int pass = p.pass;
            int total = p.tot;
            ans += (double) pass / total;
        }

        return ans / classes.length;
    }
}
