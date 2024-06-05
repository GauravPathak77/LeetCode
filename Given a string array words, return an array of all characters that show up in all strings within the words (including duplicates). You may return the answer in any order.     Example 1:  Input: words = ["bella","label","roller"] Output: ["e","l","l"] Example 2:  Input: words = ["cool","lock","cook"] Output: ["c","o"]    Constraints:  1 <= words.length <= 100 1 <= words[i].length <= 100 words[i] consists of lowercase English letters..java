class Solution {
    public List<String> commonChars(String[] words) {
        Map<Character, Integer> minFreq = new HashMap<>();
        for(int i=0; i<words[0].length(); i++){
            char ch = words[0].charAt(i);
            minFreq.put(ch, minFreq.getOrDefault(ch, 0) + 1);
        }

        for(int i=1; i<words.length; i++) {
            Map<Character, Integer> currentFreq = new HashMap<>();
            for (char ch : words[i].toCharArray()) {
                currentFreq.put(ch, currentFreq.getOrDefault(ch, 0) + 1);
            }
            for (Character ch : minFreq.keySet()) {
                if (currentFreq.containsKey(ch)) {
                    minFreq.put(ch, Math.min(minFreq.get(ch), currentFreq.get(ch)));
                } else {
                    minFreq.put(ch, 0);
                }
            }
        }

        List<String> ans = new ArrayList<>();
        for(Character key : minFreq.keySet()) {
            for (int i = 0; i < minFreq.get(key); i++) {
                ans.add(key.toString());
            }
        }

        return ans;
    }
}
