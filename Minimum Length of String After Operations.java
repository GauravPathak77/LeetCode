class Solution {
    public int minimumLength(String s) {
        Map<Character, List<Integer>> map = new HashMap<>();
        int ans = 0;

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(!map.containsKey(ch)) map.put(ch, new ArrayList<>());
            List<Integer> list = map.get(ch);
            list.add(i);
            map.put(ch, list);
        }

        for(char key : map.keySet()) {
            List<Integer> list = map.get(key);
            if(list.size() % 2 == 0) ans += 2;
            else ans += 1;
        }
        
        return ans;
    }
}
