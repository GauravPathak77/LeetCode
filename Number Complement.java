class Solution {
    public int findComplement(int num) {
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(num));

        for(int i=0; i<sb.length(); i++) {
            char ch = sb.charAt(i) == '1' ? '0' : '1';
            sb.setCharAt(i, ch); 
        }

        return Integer.parseInt(sb.toString(), 2);
    }
}
