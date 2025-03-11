class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] count = new int[3];
        int ans = 0;
        int start = 0;

        for(int end = 0; end < n; end++) {
            int idx = s.charAt(end) - 'a';
            count[idx]++;

            while(count[0] > 0 && count[1] > 0 && count[2] > 0) {
                ans += (n - end);
                idx = s.charAt(start) - 'a';
                count[idx]--;
                start++;
            }
        }

        return ans;
    }
}
