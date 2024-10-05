class Solution {
    private boolean foundSubstr(int[] s1Freq, int[] windowFreq) {
        for(int i=0; i<26; i++) {
            if(s1Freq[i] != windowFreq[i]) return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int k = s1.length();
        int[] s1Freq = new int[26];
        int[] windowFreq = new int[26];

        for(int i=0; i<k; i++) {
            s1Freq[s1.charAt(i) - 'a']++;
            windowFreq[s2.charAt(i) - 'a']++;
        }

        if(foundSubstr(s1Freq, windowFreq)) return true;

        for(int i=k; i<s2.length(); i++) {
            windowFreq[s2.charAt(i) - 'a']++;
            windowFreq[s2.charAt(i-k) - 'a']--;

            if(foundSubstr(s1Freq, windowFreq)) return true;
        }

        return false;
    }
}
