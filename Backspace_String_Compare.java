class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder s1 = new StringBuilder(s);
        StringBuilder s2 = new StringBuilder(t);
        
        for(int i=0; i < s1.length(); i++){
            if(s1.charAt(i) == '#'){
                if(i == 0){
                    s1.deleteCharAt(i);
                    i--;
                    continue;
                }
                s1.deleteCharAt(i);
                if(s1.length() == 1){
                    s1.deleteCharAt(0);
                    break;
                }
                s1.deleteCharAt(i-1);
                i-=2;
            }
        }
        
        for(int i=0; i < s2.length(); i++){
            if(s2.charAt(i) == '#'){
                if(i == 0){
                    s2.deleteCharAt(i);
                    i--;
                    continue;
                }
                s2.deleteCharAt(i);
                if(s2.length() == 1){
                    s2.deleteCharAt(0);
                    break;
                }
                s2.deleteCharAt(i-1);
                i-=2;
            }
        }
        s = s1.toString();
        t = s2.toString();
        if(s.equals(t)){
            return true;
        }
        return false;
    }
}
