class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int test = minutesToTest / minutesToDie;
        int numPigs = 0;
        int states = 1; 
        while (states < buckets) {
            states *= (test + 1);
            numPigs++;
        }
        return numPigs;
    }
}
