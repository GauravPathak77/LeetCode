class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0;
        boolean isOdd = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (Character key : map.keySet()) {
            if (map.get(key) % 2 == 0) {
                ans += map.get(key);
            } else {
                ans += map.get(key);
                if (!isOdd) {
                    isOdd = true;
                } else {
                ans -= 1;
                }
            }
        }
        
        return ans;
    }
}
