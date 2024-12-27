class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int maxScore = 0;
        int maxSoFar = values[0];

        for(int j = 1; j < values.length; j++) {
            maxScore = Math.max(maxScore, maxSoFar + values[j] - j);
            maxSoFar = Math.max(maxSoFar, values[j] + j);
        }

        return maxScore;
    }
}
