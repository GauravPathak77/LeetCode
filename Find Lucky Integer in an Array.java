class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int ans = -1;
        for(int key : map.keySet()) {
            if(map.get(key) == key) {
                ans = Math.max(ans, key);
            }
        }

        return ans;
    }
}
