class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;
        boolean[] hasKey = new boolean[n];
        boolean[] used = new boolean[n];
        boolean[] seen = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        for (int box : initialBoxes) {
            queue.offer(box);
            seen[box] = true;
        }

        int totalCandies = 0;

        while (!queue.isEmpty()) {
            boolean progress = false;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int box = queue.poll();

                if (status[box] == 0 && !hasKey[box]) {
                    queue.offer(box);
                    continue;
                }

                if (used[box]) continue;
                used[box] = true;
                totalCandies += candies[box];
                progress = true;

                for (int key : keys[box]) {
                    hasKey[key] = true;
                }

                for (int contained : containedBoxes[box]) {
                    if (!seen[contained]) {
                        queue.offer(contained);
                        seen[contained] = true;
                    }
                }
            }

            if (!progress) break;
        }

        return totalCandies;
    }
}
