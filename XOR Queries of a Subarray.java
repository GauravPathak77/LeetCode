class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];

        for(int i=0; i<n; i++) {
            int start = queries[i][0];
            int end = queries[i][1];

            int res = 0;
            while(start <= end) {
                res = res ^ arr[start];
                start++;
            }

            ans[i] = res;
        }

        return ans;
    }
}
