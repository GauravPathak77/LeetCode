class Solution {
    private static final int MOD = 1000000007;
    public int lengthAfterTransformations(String s, int t) {
        long ans = 0;
        long[] freq = new long[26];

        for(char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        while(t-- > 0) {
            long[] newFreq = new long[26];

            for(int i=0; i<26; i++) {
                if(i == 25) {
                    newFreq[0] = freq[i] % MOD;
                    newFreq[1] = (newFreq[1] + freq[i]) % MOD;
                }
                else {
                    newFreq[i+1] = freq[i] % MOD;
                }
            }

            freq = newFreq;
        }

        for(long count : freq) {
            ans = (ans + count) % MOD;
        }

        return (int) ans;
    }
}
