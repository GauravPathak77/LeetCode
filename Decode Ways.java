class Solution {
    int dp[];
    public int solve(String s, int i, int n){
        if(dp[i] != -1){
            return dp[i];
        }
        if(i == n){
            return dp[i] = 1;
        }
        if(s.charAt(i) == '0'){
            return dp[i] = 0;
        }

        int result = solve(s, i+1, n);

        if(i+1 < n){
            if(s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) <= '6')){
                result += solve(s, i+2, n);
            }
        }
        return dp[i] = result;
    }
    public int numDecodings(String s) {
        int n = s.length();
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(s, 0, n);
    }
}
