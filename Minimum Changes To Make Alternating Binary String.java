class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int opt0 = 0;
        int opt1 = 0;

        for (int i = 0; i < n; i++) {
            
            char exp0 = (i % 2 == 0) ? '0' : '1';
            char exp1 = (i % 2 == 0) ? '1' : '0';

            if (s.charAt(i) != exp0) {
                opt0++;
            }
            if (s.charAt(i) != exp1) {
                opt1++;
            }
        }

        return Math.min(opt0, opt1);
    }
}
