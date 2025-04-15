class Solution {
    static class FenwickTree {
        int[] tree;

        public FenwickTree(int size) {
            tree = new int[size + 2];
        }

        public void update(int index, int value) {
            index++;
            while (index < tree.length) {
                tree[index] += value;
                index += index & -index;
            }
        }

        public int query(int index) {
            index++;
            int sum = 0;
            while (index > 0) {
                sum += tree[index];
                index -= index & -index;
            }
            return sum;
        }

        public int queryRange(int left, int right) {
            return query(right) - query(left - 1);
        }
    }
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] posInNums2 = new int[n];
        for (int i = 0; i < n; i++) {
            posInNums2[nums2[i]] = i;
        }

        int[] mapped = new int[n];
        for (int i = 0; i < n; i++) {
            mapped[i] = posInNums2[nums1[i]];
        }

        long[] leftSmaller = new long[n];
        FenwickTree ft1 = new FenwickTree(n);
        for (int i = 0; i < n; i++) {
            leftSmaller[i] = ft1.query(mapped[i] - 1);
            ft1.update(mapped[i], 1);
        }

        long[] rightGreater = new long[n];
        FenwickTree ft2 = new FenwickTree(n);
        for (int i = n - 1; i >= 0; i--) {
            rightGreater[i] = ft2.query(n - 1) - ft2.query(mapped[i]);
            ft2.update(mapped[i], 1);
        }

        long total = 0;
        for (int i = 0; i < n; i++) {
            total += leftSmaller[i] * rightGreater[i];
        }

        return total;
    }
}
