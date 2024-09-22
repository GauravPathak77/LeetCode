class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--;

        while(k > 0) {
            long countNum = countUtil(curr, curr + 1, n);
            if(countNum <= k) {
                curr += 1;
                k -= countNum;
            } else {
                curr *= 10;
                k--;
            }
        }

        return curr;
    }

    private long countUtil(long curr, long next, int n) {
        long countRange = 0;

        while(curr <= n) {
            countRange += next - curr;
            curr *= 10;
            next = Math.min(next*10, n+1);
        }

        return countRange;
    }
}
