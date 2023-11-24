class Solution {
    public int maxCoins(int[] piles) {
        int n = piles.length;
        int t = n/3;
        Arrays.sort(piles);
        int k = n - (2*t) - 1;
        int ans = 0;
        for(int i = n-2; i>k; i = i-2){
            ans += piles[i];
        }
        return ans;
    }
}
