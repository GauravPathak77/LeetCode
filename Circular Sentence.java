class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        int n = words.length;

        if(words[0].charAt(0) != words[n-1].charAt(words[n-1].length()-1)) return false;

        for(int i = 0; i < words.length - 1; i++) {
            char ch1 = words[i].charAt(words[i].length()-1);
            char ch2 = words[i+1].charAt(0);

            if(ch1 != ch2) return false;
        }

        return true;
    }
}
