class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int ans = 0;

        for(int num : nums) {
            pq.add((long) num);
        }

        while(pq.size() > 1 && pq.peek() < k) {
            long x = pq.poll();
            long y = pq.poll();
            long res = Math.min(x, y) * 2 + Math.max(x, y);
            pq.add(res);
            ans++;
        }

        return ans;
    }
}
