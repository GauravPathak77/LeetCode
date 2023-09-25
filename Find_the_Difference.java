class Solution {
    public char findTheDifference(String s, String t) {
        int[] charCount = new int[26];

        for (char ch : s.toCharArray()) {
            charCount[ch - 'a']++;
        }

        for (char ch : t.toCharArray()) {
            if (charCount[ch - 'a'] == 0) {
                return ch;
            }
            charCount[ch - 'a']--;
        }

        return '\0';
    }
}
