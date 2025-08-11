class Solution {
    private static int MOD = 1000000007;
    public int[] productQueries(int n, int[][] queries) {
        List<Integer> powList = new ArrayList();
        int pow = 0;

        while(n > 0) {
            int rem = n % 2;
            if(rem == 1) powList.add((int)Math.pow(2, pow));
            pow++;
            n /= 2;
        }

        int m = queries.length;
        int[] ans = new int[m];
        
        for(int i = 0; i < m; i++) {
            long prod = 1;
            for(int j = queries[i][0]; j <= queries[i][1]; j++) prod = (prod * powList.get(j)) % MOD;
            ans[i] = (int)prod;
        }

        return ans;
    }
}
