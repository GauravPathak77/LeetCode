class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(s);
        Arrays.sort(g);
        int count = 0;
        int i=0, j=0;
        while(i<g.length && j<s.length){
            if(g[i] <= s[j]){
                count++;
                i++;
            }
            j++;
        }
        return count;
    }
}
