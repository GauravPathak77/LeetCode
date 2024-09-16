class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> minuteList = new ArrayList<>();
        int ans = Integer.MAX_VALUE;

        for(String time : timePoints) {
            String[] timeArray = time.split(":");
            int hour = Integer.parseInt(timeArray[0]);
            int minute = Integer.parseInt(timeArray[1]);
            int totalMinutes = hour * 60 + minute;
            minuteList.add(totalMinutes);
        }

        Collections.sort(minuteList);

        for(int i=1; i<minuteList.size(); i++) {
            int minuteDiff = minuteList.get(i) - minuteList.get(i-1);
            ans = Math.min(ans, minuteDiff);
        }

        int midNightTime = (24 * 60) - minuteList.get(minuteList.size()-1) + minuteList.get(0);
        ans = Math.min(ans, midNightTime);

        return ans;
    }
}
