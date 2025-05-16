class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (groups[i] != groups[j] 
                    && words[i].length() == words[j].length()
                    && hammingDistance(words[i], words[j]) == 1) {
                    adj.get(i).add(j);
                }
            }
        }

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        int maxLen = 1;
        int maxIndex = 0;

        for (int i = 0; i < n; i++) {
            for (int nxt : adj.get(i)) {
                if (dp[i] + 1 > dp[nxt]) {
                    dp[nxt] = dp[i] + 1;
                    parent[nxt] = i;
                    if (dp[nxt] > maxLen) {
                        maxLen = dp[nxt];
                        maxIndex = nxt;
                    }
                }
            }
        }

        LinkedList<String> result = new LinkedList<>();
        int curr = maxIndex;
        while (curr != -1) {
            result.addFirst(words[curr]);
            curr = parent[curr];
        }

        return result;
    }

    private static int hammingDistance(String s1, String s2) {
        int dist = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) dist++;
            if (dist > 1) return dist;
        }
        return dist;
    }
}
