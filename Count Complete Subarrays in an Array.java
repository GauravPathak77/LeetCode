class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int i = 0; i < n; i++) {
            Map<Integer, Integer> newMap = new HashMap<>();
            for(int j = i; j < n; j++) {
                newMap.put(nums[j], newMap.getOrDefault(nums[j], 0) + 1);
                if (newMap.size() == map.size()) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
