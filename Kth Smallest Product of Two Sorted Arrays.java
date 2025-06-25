class Solution {
    public long kthSmallestProduct(int[] n1, int[] n2, long k) {
        if (n1.length > n2.length) {
            int[] t = n1; n1 = n2; n2 = t;
        }
        long m2 = n2.length;
        long lo = Math.min(
            Math.min((long)n1[0]*n2[0], (long)n1[0]*n2[n2.length-1]),
            Math.min((long)n1[n1.length-1]*n2[0], (long)n1[n1.length-1]*n2[n2.length-1])
        );
        long hi = Math.max(
            Math.max((long)n1[0]*n2[0], (long)n1[0]*n2[n2.length-1]),
            Math.max((long)n1[n1.length-1]*n2[0], (long)n1[n1.length-1]*n2[n2.length-1])
        );
        while (lo < hi) {
            long mid = lo + (hi - lo)/2;
            if (cnt(mid, n1, n2, m2) >= k) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
    private long cnt(long x, int[] n1, int[] n2, long m2) {
        long c = 0;
        for (long a : n1) {
            if (a > 0) {
                long t = Math.floorDiv(x, a);
                c += upperBound(n2, t);
            } else if (a < 0) {
                long fd = Math.floorDiv(x, a);
                long t = fd + (x % a != 0 ? 1 : 0);
                c += m2 - lowerBound(n2, t);
            } else if (x >= 0) {
                c += m2;
            }
        }
        return c;
    }
    private int lowerBound(int[] arr, long t) {
        int l = 0, r = arr.length;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (arr[m] < t) l = m + 1;
            else r = m;
        }
        return l;
    }
    private int upperBound(int[] arr, long t) {
        int l = 0, r = arr.length;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (arr[m] <= t) l = m + 1;
            else r = m;
        }
        return l;
    }
}
