class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        TreeMap<Integer, Integer> count = new TreeMap<>();

        for(int num : basket1) count.put(num, count.getOrDefault(num, 0) + 1);
        for(int num : basket2) count.put(num, count.getOrDefault(num, 0) - 1);

        List<Integer> sur = new ArrayList<>();
        int minValue = Integer.MAX_VALUE;

        for(Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int fruit = entry.getKey();
            int diff = entry.getValue();
            minValue = Math.min(minValue, fruit);
            if(diff % 2 != 0) return -1;
            for(int i = 0; i < Math.abs(diff) / 2; i++) {
                sur.add(fruit);
            }
        }

        Collections.sort(sur);
        long cost = 0;
        int n = sur.size();

        for(int i = 0; i < n / 2; i++) {
            cost += Math.min(sur.get(i), 2 * minValue);
        }
        return cost;
    }
}
