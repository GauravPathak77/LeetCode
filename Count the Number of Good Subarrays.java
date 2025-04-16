class Solution {
    public long countGood(int[] nums, int k) {
        int left = 0;
        long goodSubarrays = 0;
        long currentPairs = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int right = 0; right < nums.length; right++) {
            int val = nums[right];
            int freq = freqMap.getOrDefault(val, 0);
            currentPairs += freq;
            freqMap.put(val, freq + 1);

            while (currentPairs >= k) {
                goodSubarrays += nums.length - right;
                int leftVal = nums[left];
                int leftFreq = freqMap.get(leftVal);
                currentPairs -= leftFreq - 1;
                if (leftFreq == 1) {
                    freqMap.remove(leftVal);
                } else {
                    freqMap.put(leftVal, leftFreq - 1);
                }
                left++;
            }
        }

        return goodSubarrays;
    }
}
