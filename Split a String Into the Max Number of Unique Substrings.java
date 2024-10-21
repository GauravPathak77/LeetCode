class Solution {
    private int solve(int idx, String s, Set<String> st) {
        if(idx == s.length()) return 0;

        int maxSplit = 0;
        StringBuilder sb = new StringBuilder();

        for(int i=idx; i<s.length(); i++) {
            sb.append(s.charAt(i));
            String subStr = sb.toString();
            if(!st.contains(subStr)) {
                st.add(subStr);
                int split = 1 + solve(i+1, s, st);
                maxSplit = Math.max(maxSplit, split);
                st.remove(subStr);
            }
        }

        return maxSplit;
    }
    public int maxUniqueSplit(String s) {
        return solve(0, s, new HashSet<>());
    }
}
