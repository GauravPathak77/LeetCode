class Solution {
    public boolean winnerOfGame(String colors) {
        int n = colors.length();
        if (n < 3) {
        return false;
        }

        int aliceCount = 0;
        int bobCount = 0;

        for (int i = 1; i < n - 1; i++) {
            if (colors.charAt(i) == 'A') {
                if (colors.charAt(i - 1) == 'A' && colors.charAt(i + 1) == 'A') {
                    aliceCount++;
                }
            } else if (colors.charAt(i) == 'B') {
                if (colors.charAt(i - 1) == 'B' && colors.charAt(i + 1) == 'B') {
                    bobCount++;
                }
            }
        }
        return aliceCount > bobCount;
    }
}
