class Solution {
    public int minCost(String colors, int[] neededTime) {
        int ans = 0;
        for(int i=0; i<colors.length()-1; i++){
            if(colors.charAt(i) == colors.charAt(i+1)){
                ans += Math.min(neededTime[i], neededTime[i+1]);
                neededTime[i+1] = Math.max(neededTime[i], neededTime[i+1]);
            }
        }
        return ans;
    }
}
