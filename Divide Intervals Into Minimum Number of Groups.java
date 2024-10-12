class Solution {
    public int minGroups(int[][] intervals) {
        int n = intervals.length;
        int[][] events = new int[2 * n][2];
        
        int index = 0;
        for (int[] interval : intervals) {
            events[index++] = new int[]{interval[0], 1};
            events[index++] = new int[]{interval[1] + 1, -1};
        }
        
        Arrays.sort(events, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        
        int maxGroups = 0, activeGroups = 0;
        
        for (int[] event : events) {
            activeGroups += event[1];
            maxGroups = Math.max(maxGroups, activeGroups);
        }
        
        return maxGroups;
    }
}
