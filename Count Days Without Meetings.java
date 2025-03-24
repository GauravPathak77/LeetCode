class Solution {
    public int countDays(int days, int[][] meetings) {
        int count = 0;
        int end = 0;
        
        Arrays.sort(meetings, (a,b) -> a[0] - b[0]);
        
        for(int start = 0; start < meetings.length; start++) {
            if(meetings[start][0] > end + 1) {
                count += meetings[start][0] - end - 1;
            }
            end = Math.max(end, meetings[start][1]);
        }
        
        if(end < days) {
            count += days - end;
        }
        
        return count;
    }
}
