class Solution {
    public String countAndSay(int n) {
        if (n <= 0) return "";

        String result = "1";

        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            char prev = result.charAt(0);

            for (int j = 1; j < result.length(); j++) {
                char curr = result.charAt(j);
                if (curr == prev) {
                    count++;
                } else {
                    sb.append(count).append(prev);
                    count = 1;
                    prev = curr;
                }
            }

            sb.append(count).append(prev);
            result = sb.toString();
        }

        return result;
    }
}
