class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            int first = s.indexOf(ch);
            int last = s.lastIndexOf(ch);
            ans = Math.max(ans, (last - first - 1));
        }
        return ans;
    }
}
