class Solution {
    public int appendCharacters(String s, String t) {
        int n = t.length();

        for(int i=0, j=0; i<s.length() && j<t.length(); i++){
            if(s.charAt(i) == t.charAt(j)){
                n--;
                j++;
            }
        }
        return n;
    }
}
