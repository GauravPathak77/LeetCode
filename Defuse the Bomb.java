class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];

        if(k == 0) return ans;

        for(int i = 0; i < n; i++) {
            int t = k;
            if(t > 0) {
                int j = i+1;
                int sum = 0;
                while(t > 0) {
                    if(j == n) j = j % n;
                    sum += code[j];
                    j++;
                    t--;
                }
                ans[i] = sum;
            } else  {
                int j = i-1;
                int sum = 0;
                while(t < 0) {
                    if(j < 0) j = n-1;
                    sum += code[j];
                    j--;
                    t++;
                }
                ans[i] = sum;
            }
        }

        return ans;
    }
}
