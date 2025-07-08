class Solution {
    private int solve(int idx, int k, int[][] events, int[][] memo) {
        int n = events.length;
        if(memo[idx][k] != -1) return memo[idx][k];
        if(idx == n || k == 0) return 0;

        int start = events[idx][0];
        int end = events[idx][1];
        int value = events[idx][2];

        int take = value;
        for(int i = idx+1; i < n; i++) {
            if(events[i][0] > end) {
                take += solve(i, k-1, events, memo);
                break;
            }
        }

        int notTake = solve(idx+1, k, events, memo);

        return memo[idx][k] = Math.max(take, notTake);
    }
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        int n = events.length;
        int[][] memo = new int[n+1][k+1];

        for(int[] row : memo) Arrays.fill(row, -1);
        return solve(0, k, events, memo);
    }
}
