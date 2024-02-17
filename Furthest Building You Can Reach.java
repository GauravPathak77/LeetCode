import java.util.PriorityQueue;

class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int i = 0;
        for(i = 0; i < heights.length-1; i++) {
            int diff = heights[i + 1] - heights[i];
            if(diff > 0) {
                if(bricks >= diff){
                    bricks -= diff;
                    pq.add(diff);
                }else if (ladders > 0) {
                    if (!pq.isEmpty() && pq.peek() > diff){
                        int top = pq.remove();
                        bricks += top - diff;
                        pq.add(diff);
                        ladders--;
                    }else{
                        ladders--;
                    }
                }else{
                    break;
                }
            }
        }
        return i;
    }
}
