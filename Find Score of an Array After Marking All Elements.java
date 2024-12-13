class Solution {
    class Pair implements Comparable<Pair> {
        int idx;
        int val;

        Pair(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }

        @Override
        public int compareTo(Pair p) {
            if(this.val == p.val) return this.idx - p.idx;
            else return this.val - p.val;
        }
    }
    public long findScore(int[] nums) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int n = nums.length;

        for(int i = 0; i < n; i++) pq.add(new Pair(i, nums[i]));

        Set<Integer> marked = new HashSet<>();
        long score = 0;

        while(!pq.isEmpty()) {
            Pair p = pq.poll();
            if(marked.contains(p.idx)) continue;

            score += p.val;
            marked.add(p.idx);
            if(p.idx > 0) marked.add(p.idx - 1);
            if(p.idx < n-1) marked.add(p.idx + 1);
        }

        return score;
    }
}
