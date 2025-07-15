class Solution {
    public boolean isValid(String word) {
        if(word.length() < 3) return false;
        boolean isVowel = false, isCons = false;

        for(char ch : word.toCharArray()) {
            if(!Character.isLetter(ch) && !Character.isDigit(ch)) return false;
            if(Character.isLetter(ch)) {
                if(Character.toLowerCase(ch) == 'a' || Character.toLowerCase(ch) == 'e' || Character.toLowerCase(ch) == 'i' || Character.toLowerCase(ch) == 'o' || Character.toLowerCase(ch) == 'u') isVowel = true;
                else isCons = true;
            }
        }

        return isVowel && isCons;
    }
}
