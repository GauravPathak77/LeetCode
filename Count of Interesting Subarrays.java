class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        Map<Integer, Long> countMap = new HashMap<>();
        countMap.put(0, 1L);
        
        long ans = 0;
        int prefix = 0;
        
        for(int num : nums) {
            if(num % modulo == k) {
                prefix++;
            }
            prefix %= modulo;
            
            int needed = (prefix - k + modulo) % modulo;
            
            ans += countMap.getOrDefault(needed, 0L);
            
            countMap.put(prefix, countMap.getOrDefault(prefix, 0L) + 1);
        }
        
        return ans;
    }
}
