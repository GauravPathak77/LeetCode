class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int prev = 0;

        for(int space : spaces) {
            String str = s.substring(prev, space);
            sb.append(str);
            sb.append(" ");
            prev = space;
        }

        sb.append(s.substring(prev));
        return sb.toString();
    }
}
