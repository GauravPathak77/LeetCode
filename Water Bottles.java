class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        
        while(numBottles / numExchange > 0) {
            int quot = numBottles / numExchange;
            int rem = numBottles % numExchange;

            ans += quot;
            numBottles = quot + rem;
        }

        return ans;
    }
}
