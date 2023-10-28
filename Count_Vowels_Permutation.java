class Solution {
    public int countVowelPermutation(int n) {
        final int MOD = 1000000007;
        
        long a = 1, e = 1, i = 1, o = 1, u = 1;
        
        for (int j = 1; j < n; j++) {
            long a_next = e;
            long e_next = (a + i) % MOD;
            long i_next = (a + e + o + u) % MOD;
            long o_next = (i + u) % MOD;
            long u_next = a;
            
            a = a_next;
            e = e_next;
            i = i_next;
            o = o_next;
            u = u_next;
        }
        
        return (int)((a + e + i + o + u) % MOD);
    }
}
