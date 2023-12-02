class Solution {
    public int countCharacters(String[] words, String chars) {
        boolean ans[] = new boolean[words.length];

        for(int i=0; i<words.length; i++){
            HashMap<Character, Integer> map = new HashMap<>();
            for(int k=0; k<chars.length(); k++){
            char ch = chars.charAt(k);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
            
            String s = words[i];
            int j=0;
            for(j=0; j<s.length(); j++){
                char ch = s.charAt(j);
                if(map.containsKey(ch)){
                    if(map.get(ch) == 0){
                        ans[i] = false;
                        break;
                    }
                    else{
                        map.put(ch, map.get(ch) - 1);
                    }
                }else{
                    ans[i] = false;
                    break;
                }
            }
            if(j == s.length()){
                ans[i] = true;
            }
        }

        int res = 0;
        for(int i=0; i<ans.length; i++){
            if(ans[i] == true){
                res += words[i].length();
            }
        }
        return res;
    }
}
