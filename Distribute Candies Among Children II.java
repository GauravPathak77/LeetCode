class Solution {
    public long distributeCandies(int n, int limit) {
        long ans = 0;

        int min_a = Math.max(0, n - 2*limit);
        int max_a = Math.min(n, limit);

        for(int i = min_a; i <= max_a; i++) {
            int N = n - i;

            int min_b = Math.max(0, N - limit);
            int max_b = Math.min(N, limit);

            ans += max_b - min_b + 1;
        }

        return ans;
    }
}
