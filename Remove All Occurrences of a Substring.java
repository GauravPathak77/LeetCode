class Solution {
    public String removeOccurrences(String s, String part) {
        int m = part.length();

        while(s.length() != 0) {
            int n = s.length();
            int idx = s.indexOf(part);

            if(idx == -1) break;
            s = s.substring(0, idx) + s.substring(idx + m, n);
        }

        return s;
    }
}
