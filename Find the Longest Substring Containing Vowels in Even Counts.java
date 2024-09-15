class Solution {
    public int findTheLongestSubstring(String s) {
        HashMap<Integer, Integer> maskIndexMap = new HashMap<>();
        maskIndexMap.put(0, -1);
        
        int maxLength = 0;
        int mask = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            switch (ch) {
                case 'a':
                    mask ^= (1 << 0);
                    break;
                case 'e':
                    mask ^= (1 << 1);
                    break;
                case 'i':
                    mask ^= (1 << 2);
                    break;
                case 'o':
                    mask ^= (1 << 3);
                    break;
                case 'u':
                    mask ^= (1 << 4);
                    break;
            }
            
            if (maskIndexMap.containsKey(mask)) {
                maxLength = Math.max(maxLength, i - maskIndexMap.get(mask));
            } else {
                maskIndexMap.put(mask, i);
            }
        }
        
        return maxLength;
    }
}
