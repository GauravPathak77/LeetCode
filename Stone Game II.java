class Solution {
    private int solveForAlice(int[] piles, int person, int i, int M, int n, int[][][] dp) {
        if (i >= n) {
            return 0;
        }
        
        if (dp[person][i][M] != -1) {
            return dp[person][i][M];
        }
        
        int result = (person == 1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int stones = 0;
        
        for (int x = 1; x <= Math.min(2*M, n-i); x++) {
            stones += piles[i+x-1];
            
            if (person == 1) {
                result = Math.max(result, stones + solveForAlice(piles, 0, i + x, Math.max(M, x), n, dp));
            } else {
                result = Math.min(result, solveForAlice(piles, 1, i + x, Math.max(M, x), n, dp));
            }
        }
        
        return dp[person][i][M] = result;
    }

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][][] dp = new int[2][n+1][n+1];
        
        for (int[][] arr2D : dp) {
            for (int[] arr1D : arr2D) {
                Arrays.fill(arr1D, -1);
            }
        }
        
        return solveForAlice(piles, 1, 0, 1, n, dp);
    }
}
