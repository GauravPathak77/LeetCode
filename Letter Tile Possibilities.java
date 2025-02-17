class Solution {
    private int solve(int[] freq) {
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                count++;
                freq[i]--;
                count += solve(freq);
                freq[i]++;
            }
        }
        return count;
    }

    public int numTilePossibilities(String tiles) {
        int[] freq = new int[26];
        for (char c : tiles.toCharArray()) {
            freq[c - 'A']++;
        }
        return solve(freq);
    }
}
