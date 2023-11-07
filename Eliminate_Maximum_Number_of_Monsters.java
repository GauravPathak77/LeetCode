class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;

        for (int i = 0; i < n; i++) {
            dist[i] = (int) Math.ceil((double) dist[i] / speed[i]);
        }

        Arrays.sort(dist);

        int i = 0;
        for (int j = 0; j < n; j++) {
            if (i >= dist[j]) {
                return i;
            }
            i++;
        }
        return n;
    }
}
