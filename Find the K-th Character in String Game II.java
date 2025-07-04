class Solution {
    public char kthCharacter(long k, int[] operations) {
        int n = operations.length;
        long[] lengths = new long[n + 1];
        lengths[0] = 1;

        for (int i = 0; i < n; i++) {
            if (operations[i] == 0) {
                lengths[i + 1] = lengths[i] * 2;
            } else {
                lengths[i + 1] = lengths[i] * 2;
            }
            if (lengths[i + 1] > k) {
                lengths[i + 1] = k;
            }
        }

        int shiftCount = 0;

        for (int i = n - 1; i >= 0; i--) {
            long len = lengths[i];
            if (operations[i] == 0) {
                if (k > len) {
                    k -= len;
                }
            } else {
                if (k > len) {
                    k -= len;
                    shiftCount++;
                }
            }
        }

        char result = (char) ((('a' - 'a' + shiftCount) % 26 + 26) % 26 + 'a');
        return result;
    }
}
