class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        int n = searchWord.length();
        int ans = -1;

        for(int i = 0; i < words.length; i++) {
            if(words[i].length() >= n) {
                String substr = words[i].substring(0, n);
                if(substr.equals(searchWord)) {
                    ans = i+1;
                    break;
                }
            }
        }

        return ans;
    }
}
