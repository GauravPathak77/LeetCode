class Solution {
    public int countPalindromicSubsequence(String inputString) {
        int[] minExist = new int[26];
        int[] maxExist = new int[26];
        for (int i = 0; i < 26; i++) {
            minExist[i] = Integer.MAX_VALUE;
            maxExist[i] = Integer.MIN_VALUE;
        }

        for (int i = 0; i < inputString.length(); i++) {
            int charIndex = inputString.charAt(i) - 'a';
            minExist[charIndex] = Math.min(minExist[charIndex], i);
            maxExist[charIndex] = Math.max(maxExist[charIndex], i);
        }
        int uniqueCount = 0;

        for (int charIndex = 0; charIndex < 26; charIndex++) {
            if (minExist[charIndex] == Integer.MAX_VALUE || maxExist[charIndex] == Integer.MIN_VALUE) {
                continue;
            }
            HashSet<Character> uniqueCharsBetween = new HashSet<>();

            for (int j = minExist[charIndex] + 1; j < maxExist[charIndex]; j++) {
                uniqueCharsBetween.add(inputString.charAt(j));
            }

            uniqueCount += uniqueCharsBetween.size();
        }

        return uniqueCount;
    }
}
