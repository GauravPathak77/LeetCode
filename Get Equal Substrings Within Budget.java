class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int currCost = 0;
        int maxLen = 0;
        int start = 0;

        for(int end = 0; end < s.length(); end++){
            int cost = Math.abs(s.charAt(end) - t.charAt(end));
            currCost += cost;

            while(currCost > maxCost){
                currCost -= Math.abs(s.charAt(start) - t.charAt(start));
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}
