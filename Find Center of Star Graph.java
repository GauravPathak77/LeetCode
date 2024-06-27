class Solution {
    public int findCenter(int[][] edges) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int[] edge : edges) {
            countMap.put(edge[0], countMap.getOrDefault(edge[0], 0) + 1);
            countMap.put(edge[1], countMap.getOrDefault(edge[1], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == edges.length) {
                return entry.getKey();
            }
        }

        return -1;
    }
}
