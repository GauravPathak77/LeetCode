class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int[] ans = new int[queries.length];
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int i = 0; i < items.length; i++) {
            int key = items[i][0];
            int val = items[i][1];

            if(map.containsKey(key)) {
                val = Math.max(map.get(key), val);
            }

            map.put(key, val);
        }

        int maxBeauty = 0;
        for(int key : map.keySet()) {
            map.put(key, Math.max(maxBeauty, map.get(key)));
            maxBeauty = map.get(key);
        }

        for(int i = 0; i < queries.length; i++) {
            int query  =queries[i];

            if(map.floorKey(query) != null) ans[i] = map.get(map.floorKey(query));
            else ans[i] = 0;
        }

        return ans;
    }
}
