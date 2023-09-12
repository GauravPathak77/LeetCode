class Solution {
    public int minDeletions(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        
        Set<Integer> uniqueFreq = new HashSet<>();        
        int deletions = 0;

        for (int freq : freqMap.values()) {
            while (uniqueFreq.contains(freq)) {
                freq--;
                deletions++;
            }
            if (freq > 0) {
                uniqueFreq.add(freq);
            }
        }
        
        return deletions;
    }
}
