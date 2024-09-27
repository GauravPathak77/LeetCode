class MyCalendarTwo {
    List<int[]> calendar;
    List<int[]> overlaps;

    public MyCalendarTwo() {
        calendar = new ArrayList<>();
         overlaps = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for (int[] overlap : overlaps) {
            if (start < overlap[1] && end > overlap[0]) {
                return false;
            }
        }

        for (int[] event : calendar) {
            if (start < event[1] && end > event[0]) {
                int overlapStart = Math.max(start, event[0]);
                int overlapEnd = Math.min(end, event[1]);
                overlaps.add(new int[]{overlapStart, overlapEnd});
            }
        }

        calendar.add(new int[]{start, end});
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
