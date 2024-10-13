class Solution {
    class Element {
        int value;
        int listIndex;
        int elementIndex;
        
        Element(int value, int listIndex, int elementIndex) {
            this.value = value;
            this.listIndex = listIndex;
            this.elementIndex = elementIndex;
        }
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Element> minHeap = new PriorityQueue<>((a, b) -> a.value - b.value);
        int max = Integer.MIN_VALUE;
        int start = 0, end = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.size(); i++) {
            int value = nums.get(i).get(0);
            minHeap.offer(new Element(value, i, 0));
            max = Math.max(max, value);
        }
        
        while (minHeap.size() == nums.size()) {
            Element current = minHeap.poll();
            int minValue = current.value;
            
            if (max - minValue < end - start) {
                start = minValue;
                end = max;
            }
            
            if (current.elementIndex + 1 < nums.get(current.listIndex).size()) {
                int nextValue = nums.get(current.listIndex).get(current.elementIndex + 1);
                minHeap.offer(new Element(nextValue, current.listIndex, current.elementIndex + 1));
                max = Math.max(max, nextValue);
            } else {
                break;
            }
        }
        
        return new int[] {start, end};
    }
}
