class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (sentence1.equals(sentence2)) return true;

        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");
        
        int s1si = 0, s1ei = s1.length - 1;
        int s2si = 0, s2ei = s2.length - 1;

        while (s1si <= s1ei && s2si <= s2ei && s1[s1si].equals(s2[s2si])) {
            s1si++;
            s2si++;
        }
        
        while (s1ei >= s1si && s2ei >= s2si && s1[s1ei].equals(s2[s2ei])) {
            s1ei--;
            s2ei--;
        }
        
        return s1ei < s1si || s2ei < s2si;

    }
}
