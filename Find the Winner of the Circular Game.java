class Solution {
    public int findTheWinner(int n, int k) {
        return findTheWinnerUtil(n, k) + 1;
    }

    private static int findTheWinnerUtil(int n, int k) {
        if (n == 1) {
            return 0;
        } else {
            int res = findTheWinnerUtil(n - 1, k) + k;
            return res % n;
        }
    }
}
