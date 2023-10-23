class Solution {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false; 
        }
        
        if ((n & (n - 1)) != 0) {
            return false;
        }
        
        int logBase4 = (int) (Math.log(n) / Math.log(4));
        return Math.pow(4, logBase4) == n;
    }
}
