class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int ans = 0;
        boolean isSinglePal = false;

        for(String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for(String word : words) {
            if(!map.containsKey(word) || map.get(word) == 0) continue;
            int freq = map.get(word);

            if(word.charAt(0) == word.charAt(1)) {
                if(freq > 1) {
                    ans += 4 * (freq / 2);
                }
                if(freq % 2 == 1) isSinglePal = true;
            }
            else {
                String revWord = new StringBuilder(word).reverse().toString();
                if(map.containsKey(revWord)) {
                    int res = Math.min(map.get(word), map.get(revWord));
                    ans += 4 * res;
                    map.put(revWord, 0);
                }
            }

            map.put(word, 0);
        }

        if(isSinglePal) ans += 2;

        return ans;
    }
}
