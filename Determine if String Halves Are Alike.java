class Solution {
    public boolean halvesAreAlike(String s) {
        int length = s.length();
        int vowelCountA = countVowels(s.substring(0, length / 2));
        int vowelCountB = countVowels(s.substring(length / 2));

        return vowelCountA == vowelCountB;
    }
    private static int countVowels(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (isVowel(c)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
