class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        int arrivalTime = times[targetFriend][0];
        Arrays.sort(times, (a, b) -> Integer.compare(a[0], b[0]));
        int[] chairs = new int[n];

        for(int[] row : times) {
            int arrival = row[0];
            int departure = row[1];

            for(int i=0; i<n; i++) {
                if(chairs[i] <= arrival) {
                    chairs[i] = departure;
                    if(arrival == arrivalTime) return i;
                    break;
                }
            }
        }

        return -1;
    }
}
