public class Solution {
    public int longestSubsequence(String s, int k) {
        int ans = 0;
        int bits = (int)(Math.log(k) / Math.log(2)) + 1;

        int sum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if(ch == '0') ans += 1;
            else {
                if (i < s.length() - bits || sum + (1 << (s.length() - 1 - i)) > k) ans += 0;
                else {
                    sum += 1 << (s.length() - 1 - i);
                    if (sum > -1) ans += 1;
                }
            }

        }

        return ans;
    }
}
