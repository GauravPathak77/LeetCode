class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        if(n < k) return 0;
        int ans = 0;
        int count = 1;

        for(int i = 1; i < k; i++) {
            if(colors[i] != colors[i-1]) count++;
        }

        if(count == k) ans++;

        for(int start = 1; start < n; start++) {
            int prevStart = start-1;
            int end = (start + k - 1) % n;
            int prevEnd = (start + k - 2) % n;

            if(colors[prevStart] != colors[start]) count--;
            if(colors[prevEnd] != colors[end]) count++;

            if(count == k) ans++;
        }

        return ans;
    }
}
