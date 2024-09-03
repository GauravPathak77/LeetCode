class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();

        for(char ch : s.toCharArray()) {
            sb.append(ch - 'a' + 1);
        }

        while(k-- > 0) {
            long sum = 0;
            for(int i=0; i<sb.length(); i++) {
                int x = Character.getNumericValue(sb.charAt(i));
                sum += x;
            }
            sb = new StringBuilder(Long.toString(sum));
        }

        return Integer.valueOf(sb.toString());
    }
}
