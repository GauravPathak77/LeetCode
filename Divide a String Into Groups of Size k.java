class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int size = (n + k - 1) / k;
        String[] ans = new String[size];
        int idx = 0;

        for (int i = 0; i < n; i += k) {
            String group;
            if (i + k <= n) {
                group = s.substring(i, i + k);
            } else {
                StringBuilder sb = new StringBuilder(s.substring(i));
                while (sb.length() < k) {
                    sb.append(fill);
                }
                group = sb.toString();
            }
            ans[idx++] = group;
        }

        return ans;
    }
}
