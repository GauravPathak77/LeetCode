class Solution {
    public boolean canConstruct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();

        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int evenfreq = 0, oddCount = 0;

        for(char key : map.keySet()) {
            int freq = map.get(key);

            if(freq % 2 == 0) evenfreq += freq;
            else if(freq == 1) oddCount++;
            else {
                evenfreq += freq - 1;
                oddCount++;
            }

            if(oddCount > k) return false;
        }

        if(evenfreq + oddCount < k) return false;
        else return true;
    }
}
