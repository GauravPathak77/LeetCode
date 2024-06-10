class Solution {
    public int heightChecker(int[] heights) {
        int n = heights.length;
        int[] temp = new int[n];
        int ans = 0;

        for(int i=0; i<n; i++){
            temp[i] = heights[i];
        }

        Arrays.sort(temp);
        for(int i=0; i<n; i++){
            if(heights[i] != temp[i]){
                ans++;
            }
        }

        return ans;
    }
}
