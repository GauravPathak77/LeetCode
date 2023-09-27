class Solution {
    public String decodeAtIndex(String s, int k) {
        long decodedLength = 0;
        int i;

        for (i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int digit = c - '0';
                decodedLength *= digit;
            } else {
                decodedLength++;
            }
        }

        for (i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int digit = c - '0';
                decodedLength /= digit;
                k %= decodedLength;
            } else {
                if (k == 0 || k == decodedLength) {
                    return Character.toString(c);
                }
                decodedLength--;
            }
        }

        return null;
    }
}
