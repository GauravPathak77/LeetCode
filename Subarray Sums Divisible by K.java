class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int ans = 0;
        
        for (int num : nums) {
            sum += num;
            int val = ((sum % k) + k) % k;
            ans += map.getOrDefault(val, 0);
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        
        return ans;
    }
}
