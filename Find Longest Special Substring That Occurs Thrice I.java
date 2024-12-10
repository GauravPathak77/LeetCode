class Solution {
    public int maximumLength(String s) {
        int maxLength = -1;
        int n = s.length();

        for (int len = 1; len <= n; len++) {
            Map<String, Integer> freqMap = new HashMap<>();

            for (int i = 0; i <= n - len; i++) {
                String substring = s.substring(i, i + len);

                if (isSpecial(substring)) {
                    freqMap.put(substring, freqMap.getOrDefault(substring, 0) + 1);

                    if (freqMap.get(substring) >= 3) {
                        maxLength = Math.max(maxLength, len);
                    }
                }
            }
        }
        return maxLength;
    }

    private boolean isSpecial(String str) {
        char firstChar = str.charAt(0);
        for (char c : str.toCharArray()) {
            if (c != firstChar) {
                return false;
            }
        }
        return true;
    }
}
