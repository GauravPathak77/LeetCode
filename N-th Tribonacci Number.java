class Solution {
    public int tribonacci(int n) {
        int dp[] = new int[n+1];
        return tribonacciUtil(n, dp);
    }
    public int tribonacciUtil(int n, int dp[]){
        if(n <= 0){
            return 0;
        }
        if(n == 1 || n == 2){
            return 1;
        }
        if(dp[n] != 0){
            return dp[n];
        }
        return dp[n] = tribonacciUtil(n-1, dp) + tribonacciUtil(n-2, dp) + tribonacciUtil(n-3, dp);
    }
}
