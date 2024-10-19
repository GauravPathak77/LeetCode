class Solution {
    private String invert(String str) {
        StringBuilder binarySB = new StringBuilder();
        for(char ch : str.toCharArray()) {
            int newBit = ch == '0' ? 1 : 0;
            binarySB.append(newBit);
        }
        return binarySB.toString();
    }
    public char findKthBit(int n, int k) {
        String str = "0";
        for(int i=1; i<=n; i++) {
            StringBuilder sb = new StringBuilder(invert(str));
            str = str + "1" + sb.reverse();
        }

        return k <= str.length() ? str.charAt(k-1) : ' ';
    }
}
