class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] outgoingTrusts = new int[n + 1];
        int[] incomingTrusts = new int[n + 1];

        for (int[] pair : trust) {
            outgoingTrusts[pair[0]]++;
            incomingTrusts[pair[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (outgoingTrusts[i] == 0 && incomingTrusts[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}
