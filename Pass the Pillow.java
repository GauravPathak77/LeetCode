class Solution {
    public int passThePillow(int n, int time) {
        int cycleTime = 2 * (n - 1);
        int effTime = time % cycleTime;
        
        if (effTime < n) {
            return effTime + 1;
        } else {
            return cycleTime - effTime + 1;
        }
    }
}
