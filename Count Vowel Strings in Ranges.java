class Solution {
    private boolean isVowel(char ch) {
        String str = "aeiou";
        if(str.indexOf(ch) != -1) return true;
        else return false;
    }
    
    public int[] vowelStrings(String[] words, int[][] queries) {
        int m = words.length;
        int n = queries.length;
        int[] prefix = new int[m];
        int[] ans = new int[n];

        prefix[0] = isVowel(words[0].charAt(0)) && isVowel(words[0].charAt(words[0].length() - 1)) ? 1 : 0;
        for (int i = 1; i < m; i++) {
            prefix[i] = prefix[i - 1] + (isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(words[i].length() - 1)) ? 1 : 0);
        }

        for (int i = 0; i < n; i++) {
            int li = queries[i][0];
            int ri = queries[i][1];
            ans[i] = prefix[ri] - (li > 0 ? prefix[li - 1] : 0);
        }

        return ans;
    }
}
