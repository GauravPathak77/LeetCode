class Solution {
    public String makeFancyString(String s) {
        if(s.length() < 3) return s;

        StringBuilder sb = new StringBuilder();
        Set<Integer> st = new HashSet<>();
        int i = 0, j = 1, k = 2;

        while(k < s.length()) {
            if(s.charAt(i) == s.charAt(j) && s.charAt(j) == s.charAt(k)) {
                st.add(i);
            }
            i++; j++; k++;
        }

        for(int idx = 0; idx < s.length(); idx++) {
            if(!st.contains(idx)) {
                sb.append(s.charAt(idx));
            }
        }

        return sb.toString();
    }
}
