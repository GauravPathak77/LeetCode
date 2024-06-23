class Solution {
    public void adjust(Deque<Pair<Integer, Integer>> mono, int left) {
        while (!mono.isEmpty() && mono.peekFirst().getValue() < left) {
            mono.pollFirst();
        }
    }
    
    public int longestSubarray(int[] nums, int limit) {
        int ans = 0;
        Deque<Pair<Integer, Integer>> monoMax = new ArrayDeque<>();
        Deque<Pair<Integer, Integer>> monoMin = new ArrayDeque<>();
        
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!monoMax.isEmpty() && nums[i] > monoMax.peekLast().getKey()) {
                monoMax.pollLast();
            }
            while (!monoMin.isEmpty() && nums[i] < monoMin.peekLast().getKey()) {
                monoMin.pollLast();
            }
            
            monoMin.offerLast(new Pair<>(nums[i], i));
            monoMax.offerLast(new Pair<>(nums[i], i));
            
            while (true) {
                adjust(monoMin, j);
                adjust(monoMax, j);
                if (monoMax.peekFirst().getKey() - monoMin.peekFirst().getKey() > limit) {
                    j++;
                } else {
                    break;
                }
            }
            
            ans = Math.max(ans, i - j + 1);
        }
        
        return ans;
    }
}
