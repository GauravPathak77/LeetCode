class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> st = new HashSet<>();
        int ans = 0;

        for(char ch : allowed.toCharArray()) {
            st.add(ch);
        }

        for(String str : words) {
            int n = str.length();
            int i = 0;
            while(i < n) {
                char ch = str.charAt(i);
                if(!st.contains(ch)) break;
                i++;
            }

            if(i == n) ans++;
        }

        return ans;
    }
}
