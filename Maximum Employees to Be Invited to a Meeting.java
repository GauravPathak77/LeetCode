class Solution {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int[] inDegree = new int[n];

        for (int f : favorite) {
            inDegree[f]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] longestPath = new int[n];
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            int fav = favorite[curr];
            longestPath[fav] = Math.max(longestPath[fav], longestPath[curr] + 1);
            if (--inDegree[fav] == 0) {
                queue.offer(fav);
            }
        }

        boolean[] visited = new boolean[n];
        boolean[] inStack = new boolean[n];
        int maxCycleSize = 0;
        int chainSum = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                maxCycleSize = Math.max(maxCycleSize, dfs(i, favorite, visited, inStack, longestPath));
            }
        }

        for (int i = 0; i < n; i++) {
            if (favorite[favorite[i]] == i && i < favorite[i]) {
                chainSum += 2 + longestPath[i] + longestPath[favorite[i]];
            }
        }

        return Math.max(maxCycleSize, chainSum);
    }

    private int dfs(int node, int[] favorite, boolean[] visited, boolean[] inStack, int[] longestPath) {
        if (visited[node]) {
            return 0;
        }

        visited[node] = true;
        inStack[node] = true;
        int fav = favorite[node];

        int cycleSize = 0;
        if (!visited[fav]) {
            cycleSize = dfs(fav, favorite, visited, inStack, longestPath);
        } else if (inStack[fav]) {
            int current = fav;
            do {
                cycleSize++;
                current = favorite[current];
            } while (current != fav);
        }

        inStack[node] = false;
        return cycleSize;
    }
}
