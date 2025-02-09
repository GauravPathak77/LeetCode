class Solution {
    public long countBadPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        long totalPairs = (long) nums.length * (nums.length - 1) / 2;
        long goodPairs = 0;

        for (int i = 0; i < nums.length; i++) {
            int key = nums[i] - i;
            if (map.containsKey(key)) {
                goodPairs += map.get(key);
            }
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        return totalPairs - goodPairs;
    }
}
