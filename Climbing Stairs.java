class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        return ways(n, dp);
    }
    private int ways(int n, int dp[]){
        if(n<=1){
            return 1;
        }
        if(dp[n] != 0){
            return dp[n];
        }
        return dp[n] = ways(n-1, dp) + ways(n-2, dp);
    }
}
