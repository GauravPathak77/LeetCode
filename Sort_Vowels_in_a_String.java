class Solution {
    public String sortVowels(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        StringBuilder vowels = new StringBuilder();
        StringBuilder consonants = new StringBuilder();

        for (char ch : chars) {
            if (isVowel(ch)) {
                vowels.append(ch);
            } else {
                consonants.append(ch);
            }
        }

        char[] sortedVowels = vowels.toString().toCharArray();
        Arrays.sort(sortedVowels);

        StringBuilder result = new StringBuilder();
        int vowelIndex = 0, consonantIndex = 0;

        for (char ch : chars) {
            if (isVowel(ch)) {
                result.append(sortedVowels[vowelIndex++]);
            } else {
                result.append(consonants.charAt(consonantIndex++));
            }
        }

        return result.toString();
    }

    private static boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) != -1;
    }
}
