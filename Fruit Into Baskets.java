class Solution {
    public int totalFruit(int[] fruits) {
        if(fruits.length < 2) return fruits.length;

        int ans= 0;
        int i = 0, j = 1;
        int f1 = 0, f2 = -1;

        while(j < fruits.length && i < j) {
            if(f2 == -1) {
                if(fruits[j] != fruits[f1]) f2 = j;
                else {
                    j++;
                    continue;
                }
            }

            if(fruits[j] != fruits[f1] && fruits[j] != fruits[f2]) {
                ans = Math.max(ans, j-i);
                int prev = i;

                for(int k = i; k < j; k++) {
                    if(fruits[k] != fruits[j-1]) prev = k+1;
                }
                
                i = prev;
                f1 = i;
                f2 = j;
            }
            j++;
        }

        ans = Math.max(ans, j-i);
        return ans;
    }
}
