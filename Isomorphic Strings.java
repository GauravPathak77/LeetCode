class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        if(s.length() != t.length()){
            return false;
        }
           
           for(Integer i=0; i<s.length(); i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            if(map1.put(ch1, i) != map2.put(ch2, i))
            return false;
        }
  
        return true;
    }
}
