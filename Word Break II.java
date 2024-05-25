class Solution {
        public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        helper(s, wordDict, res, "");
        return res;
    }

    private void helper(String s, List<String> wordDict, List<String> res, String currString) {
        if (s.isEmpty()) {
            return;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                String newCurrString = currString.isEmpty() ? word : currString + " " + word;
                if (s.length() == word.length()) {
                    res.add(newCurrString);
                } else {
                    helper(s.substring(word.length()), wordDict, res, newCurrString);
                }
            }
        }
    }
}
