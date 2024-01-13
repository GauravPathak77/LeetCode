class Solution {
    public int minSteps(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> temp = new HashMap<>();
        int ans = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            char ch2 = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            temp.put(ch2, temp.getOrDefault(ch2, 0) + 1);
        }

        for(int i=0; i<t.length(); i++){
            char ch = t.charAt(i);
            if(!map.containsKey(ch)){
                ans++;
            }
            else if(temp.containsKey(ch)){
                if(temp.get(ch) > map.get(ch)){
                    ans += (temp.get(ch) - map.get(ch));
                    temp.remove(ch);
                }
            }
        }
        return ans;
    }
}
