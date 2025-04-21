class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long minPrefix = 0, maxPrefix = 0;
        long prefixSum = 0;

        for(int diff : differences) {
            prefixSum += diff;
            minPrefix = Math.min(minPrefix, prefixSum);
            maxPrefix = Math.max(maxPrefix, prefixSum);
        }

        long minStart = lower - minPrefix;
        long maxStart = upper - maxPrefix;

        return (int) Math.max(0, maxStart - minStart + 1);
    }
}
