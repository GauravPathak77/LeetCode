class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        boolean[][] seen = new boolean[26][26];

        int[] left = new int[26];
        int[] right = new int[26];

        for (char c : s.toCharArray()) {
            right[c - 'a']++;
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            char mid = s.charAt(i);

            right[mid - 'a']--;

            for (int c = 0; c < 26; c++) {
                if (left[c] > 0 && right[c] > 0 && !seen[c][mid - 'a']) {
                    seen[c][mid - 'a'] = true;
                    count++;
                }
            }

            left[mid - 'a']++;
        }

        return count;
    }
}
