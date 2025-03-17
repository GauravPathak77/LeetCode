class Solution {
    public boolean divideArray(int[] nums) {
        int n = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int pairSize = 0;

        for(int key : map.keySet()) {
            int freq = map.get(key);
            pairSize += freq / 2;
        }

        return pairSize == n;
    }
}
