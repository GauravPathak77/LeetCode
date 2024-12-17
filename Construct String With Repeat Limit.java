class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        TreeMap<Character, Integer> map = new TreeMap<>(Collections.reverseOrder());
            
        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        TreeSet<Character> st = new TreeSet<>(Collections.reverseOrder());
        st.addAll(map.keySet());

        while(!st.isEmpty()) {
            Character ch = st.pollFirst();
            int freq = map.get(ch);

            for(int i = 1; i <= repeatLimit && freq > 0; i++) {
                sb.append(ch);
                freq--;
            }

            if(freq == 0) continue;

            map.put(ch, freq);

            if(!st.isEmpty()) {
                char newCh = st.pollFirst();
                sb.append(newCh);
                freq = map.get(newCh);
                map.put(newCh, freq - 1);
                if(freq > 1) st.add(newCh);
                st.add(ch);
            }
        }

        return sb.toString();
    }
}
