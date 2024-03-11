class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<order.length(); i++){
            char ch = order.charAt(i);
            if(map.containsKey(ch)){
                sb.append(ch);
                map.put(ch, map.get(ch)-1);
                int t = map.get(ch);
                while(t-- > 0){
                    sb.append(ch);
                }
                map.remove(ch);
            }
        }

        for(Character key : map.keySet()){
            int t = map.get(key);
            while(t-- > 0){
                sb.append(key);
            }
        }
        return sb.toString();
    }
}
