class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int a_count[] = new int[n];
        int b_count[] = new int[n];
        int ans = Integer.MAX_VALUE;

        for(int i = n-2; i>= 0; i--) {
            if(s.charAt(i+1) == 'a') {
                a_count[i] = a_count[i+1] + 1;
            } else {
                a_count[i] = a_count[i+1];
            }
        }

        for(int i=1; i<n; i++) {
            if(s.charAt(i-1) == 'b') {
                b_count[i] = b_count[i-1] + 1;
            } else {
                b_count[i] = b_count[i-1];
            }
        }

        for(int i=0; i<n; i++) {
            ans = Math.min(ans, a_count[i] + b_count[i]);
        }

        return ans;
    }
}
