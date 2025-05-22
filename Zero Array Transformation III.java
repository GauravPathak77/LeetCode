class Solution {
    public static int maxRemoval(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] endCount = new int[n];

        for (int[] query : queries)
            endCount[query[0]]++;

        int[][] groupedEnds = new int[n][];
        for (int i = 0; i < n; i++)
            groupedEnds[i] = new int[endCount[i]];

        for (int[] query : queries)
            groupedEnds[query[0]][--endCount[query[0]]] = query[1];

        int removedCount = 0;
        Queue<Integer> activeEnds = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            for (int end : groupedEnds[i])
                activeEnds.offer(-end);

            int required = nums[i] - removedCount;
            if (required > 0) {
                if (required > activeEnds.size()) return -1;
                removedCount += required;
                while (required-- > 0) {
                    int end = -activeEnds.poll();
                    if (end < i) return -1;
                    endCount[end]++;
                }
            }

            removedCount -= endCount[i];
        }

        return activeEnds.size();
    }
}
