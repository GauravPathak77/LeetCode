class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(arr[a[0]] * arr[b[1]], arr[a[1]] * arr[b[0]]));

        for (int i = 0; i < arr.length - 1; i++) {
            pq.add(new int[] { i, arr.length - 1 });
        }

        for (int i = 1; i < k; i++) {
            int[] frac = pq.poll();
            int numeratorIndex = frac[0];
            int denominatorIndex = frac[1];

            if (denominatorIndex - 1 > numeratorIndex) {
                pq.add(new int[] { numeratorIndex, denominatorIndex - 1 });
            }
        }

        int[] result = pq.poll();
        return new int[] { arr[result[0]], arr[result[1]] };
    }
}
