class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        int idx = 0;
        long total = 0;

        for(int c : chalk) {
            total += c;
        }

        k %= total;

        while(k >= chalk[idx]) {
            k -= chalk[idx];
            idx = (idx+1) % n;
        }

        return idx;
    }
}
