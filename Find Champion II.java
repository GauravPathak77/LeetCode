class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] indeg = new int[n];
        int ans = -1;

        for(int i = 0; i < edges.length; i++) {
            int dest = edges[i][1];
            indeg[dest]++;
        }

        for(int i = 0; i < n; i++) {
            if(indeg[i] == 0) {
                if(ans == -1) ans = i;
                else return -1;
            } 
        }

        return ans;
    }
}
