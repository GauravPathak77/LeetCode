class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        PriorityQueue<long[]> pq = new PriorityQueue<>(
                (a, b) -> a[0] == b[0] ? (int) (a[1] - b[1]) : (int) (a[0] - b[0]));

        int[] room_cnt = new int[n];
        int result = 0;

        for (int i = 0; i < n; i++) {
            pq.add(new long[] { 0, i });
        }

        for (int[] item : meetings) {
            int time = item[0];

            while (pq.peek()[0] < time) {
                pq.add(new long[] { time, pq.poll()[1] });
            }
            long[] cur = pq.poll();
            int cur_room = (int) cur[1];
            long meeting_time_end = cur[0] + (item[1] - item[0]);
            room_cnt[cur_room]++;

            if (room_cnt[cur_room] > room_cnt[result]) {
                result = cur_room;
            } else if (room_cnt[cur_room] == room_cnt[result]) {
                result = Math.min(result, cur_room);
            }
            pq.add(new long[] { meeting_time_end, cur_room });

        }

        return result;
    }
}
