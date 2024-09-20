class Solution {
    public String shortestPalindrome(String s) {
        StringBuilder rev = new StringBuilder(s).reverse();
        int n = s.length();

        for(int i=0; i<n; i++) {
            if(s.substring(0, n-i).equals(rev.substring(i))) {
                return rev.substring(0,i) + s;
            }
        }

        return rev + s;
    }
}
