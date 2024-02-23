class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        int[] visited = new int[n];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[src] = 0;
        
        for (int[] flight : flights) {
            map.computeIfAbsent(flight[0], key -> new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        }
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{src, 0});
        k++;
        
        while (!queue.isEmpty() && k-- > 0) {
            int size = queue.size();
            while (size-- > 0) {
                int[] curr = queue.remove();
                int currNode = curr[0];
                int currPrice = curr[1];
                if (map.containsKey(currNode)) {
                    for (int[] neighbor : map.get(currNode)) {
                        int newPrice = currPrice + neighbor[1];
                        if (newPrice < visited[neighbor[0]]) {
                            visited[neighbor[0]] = newPrice;
                            queue.add(new int[]{neighbor[0], newPrice});
                        }
                    }
                }
            }
        }
        
        return visited[dst] == Integer.MAX_VALUE ? -1 : visited[dst];
    }
}
