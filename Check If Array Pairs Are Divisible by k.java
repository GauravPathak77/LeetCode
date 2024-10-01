class Solution {
    public boolean canArrange(int[] arr, int k) {
         Map<Integer, Integer> remainderCount = new HashMap<>();
        
        for (int num : arr) {
            int remainder = ((num % k) + k) % k;
            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
        }
        
        for (int rem : remainderCount.keySet()) {
            int count = remainderCount.get(rem);

            if (rem == 0) {
                if (count % 2 != 0) return false;
            } else {
                int complementCount = remainderCount.getOrDefault(k - rem, 0);
                if (count != complementCount) return false;
            }
        }

        return true;
    }
}
