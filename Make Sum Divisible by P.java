class Solution {
    public int minSubarray(int[] nums, int p) {
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        long remainder = totalSum % p;
        if (remainder == 0) {
            return 0;
        }
        
        HashMap<Long, Integer> prefixModMap = new HashMap<>();
        prefixModMap.put(0L, -1);
        
        long prefixSum = 0;
        int minLength = nums.length;
        
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            
            long currentMod = prefixSum % p;
            
            long targetMod = (currentMod - remainder + p) % p;
            
            if (prefixModMap.containsKey(targetMod)) {
                minLength = Math.min(minLength, i - prefixModMap.get(targetMod));
            }
            
            prefixModMap.put(currentMod, i);
        }
        
        return minLength == nums.length ? -1 : minLength;
    }
}
