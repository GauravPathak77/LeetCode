class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int ans = 0;
        List<Integer> list = new ArrayList<>();
        list.add(startTime[0]);

        for (int i = 1; i < n; i++) {
            list.add(startTime[i] - endTime[i - 1]);
        }

        list.add(eventTime - endTime[n - 1]);

        int currSum = 0;

        for (int i = 0; i < list.size(); ++i) {
            currSum += list.get(i);
            if (i >= k + 1) {
                currSum -= list.get(i - (k + 1));
            }
            ans = Math.max(ans, currSum);
        }

        return ans;
    }
}
