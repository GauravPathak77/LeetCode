class Solution {
    public String answerString(String word, int numFriends) {
        if (numFriends == 1){
            return word;
        }
        int n = word.length();
        int m = n - numFriends + 1;
        int i = 0, j = 1;
        while (j < n){
            int k = 0;
            while (j + k < n && word.charAt(i + k) == word.charAt(j + k)){
                k++;
            }
            if (j + k < n && word.charAt(i + k) < word.charAt(j + k)){
                int temp = i;
                i = j;
                j = Math.max(j + 1, temp + k + 1);
            } else {
                j += k + 1;
            }
        }
        String s = word.substring(i);
        return s.length() <= m ? s : s.substring(0, m);
    }
}
