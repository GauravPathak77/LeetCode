class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int n = dominoes.length;
        int ans = 0;
        int[] count = new int[100];

        for(int[] domino : dominoes) {
            int a = domino[0];
            int b = domino[1];

            int key = (a < b) ? a * 10 + b : b * 10 + a;
            ans += count[key];
            count[key]++;
        }

        return ans;
    }
}
