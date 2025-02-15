class Solution {
    private boolean solve(String s, int idx, int target) {
        if(idx == s.length()) {
            return target == 0;
        }
        int num = 0;
        for(int i = idx; i < s.length(); i++) {
            num = num * 10 + (s.charAt(i) - '0');
            if(num > target) break;
            if(solve(s, i + 1, target - num)) {
                return true;
            }
        }
        return false;
    }
    public int punishmentNumber(int n) {
        int ans = 0;
        for(int i = 1; i <= n; i++) {
            int sq = i * i;
            if(solve(String.valueOf(sq), 0, i)) {
                ans += sq;
            }
        }
        return ans;
    }
}
