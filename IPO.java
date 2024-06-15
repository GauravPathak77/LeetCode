class Solution {
    class IPO {
        int profit;
        int cap;

        IPO(int profit, int cap) {
            this.profit = profit;
            this.cap = cap;
        }
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
         PriorityQueue<IPO> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.cap, b.cap));
        PriorityQueue<IPO> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.profit, a.profit));

        int n = profits.length;
        for(int i = 0; i < n; i++) {
            minHeap.offer(new IPO(profits[i], capital[i]));
        }

        for(int i = 0; i < k; i++) {
            while(!minHeap.isEmpty() && minHeap.peek().cap <= w) {
                maxHeap.offer(minHeap.poll());
            }

            if(maxHeap.isEmpty()) {
                break;
            }

            w += maxHeap.poll().profit;
        }

        return w;
    }
}
