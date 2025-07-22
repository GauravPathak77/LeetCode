class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Map<Integer, Integer> idxMap = new HashMap<>();
        Map<Integer, Integer> sumMap = new HashMap<>();
        int ans = 0, currSum = 0, prevSum = 0;
        int idx = 0, prevIdx = -1;

        while(idx < nums.length) {
            if(idxMap.containsKey(nums[idx]) && idxMap.get(nums[idx]) > prevIdx) {
                prevIdx = idxMap.get(nums[idx]);
                ans = Math.max(ans, currSum - prevSum);
                prevSum += sumMap.get(prevIdx) - prevSum;
            }

            currSum += nums[idx];
            idxMap.put(nums[idx], idx);
            sumMap.put(idx, currSum);
            idx++;
        }

        return Math.max(ans, currSum - prevSum);
    }
}
