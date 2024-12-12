class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long ans = 0;

        for(int gift : gifts) {
            pq.add(gift);
        }

        while(k-- > 0) {
            int num = pq.poll();
            num = (int)Math.floor(Math.sqrt(num));
            pq.add(num);
        }

        while(!pq.isEmpty()) {
            ans += pq.poll();
        }

        return ans;
    }
}
