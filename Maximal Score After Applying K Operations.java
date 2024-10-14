class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        long ans = 0;

        for(int num : nums) pq.add(num);

        while(k-- > 0) {
            int val = pq.poll();
            ans += val;
            val = (val + 2) / 3;
            pq.add(val);
        }

        return ans;
    }
}
