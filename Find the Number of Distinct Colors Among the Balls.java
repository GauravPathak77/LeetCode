class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];

        Map<Integer, Integer> ballColor = new HashMap<>();
        Map<Integer, Integer> colorFreq = new HashMap<>();
        int disColor = 0;

        for(int i = 0; i < n; i++) {
            int ball = queries[i][0];
            int newColor = queries[i][1];

            if(ballColor.containsKey(ball)) {
                int oldColor = ballColor.get(ball);
                
                colorFreq.put(oldColor, colorFreq.get(oldColor) - 1);
                if(colorFreq.get(oldColor) == 0) {
                    disColor--;
                    colorFreq.remove(oldColor);
                }
            }

            ballColor.put(ball, newColor);

            colorFreq.put(newColor, colorFreq.getOrDefault(newColor, 0) + 1);
            if (colorFreq.get(newColor) == 1) {
                disColor++;
            }

            ans[i] = disColor;
        }

        return ans;
    }
}
