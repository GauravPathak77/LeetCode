class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();

        if(n < k) return -1;
        int ans = Integer.MAX_VALUE;
        int start = 0, end = k-1;

        while(end < n) {
            int wCount = 0;
            for(int i = start; i <= end; i++) {
                if(blocks.charAt(i) == 'W') wCount++;
            }
            ans = Math.min(ans, wCount);
            start++; 
            end++;
        }

        return ans;
    }
}
