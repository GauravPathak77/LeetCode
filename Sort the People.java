class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        TreeMap<Integer, String> map = new TreeMap<>();
        String[] ans = new String[names.length];

        for(int i=0; i<heights.length; i++) {
            map.put(heights[i], names[i]);
        }

        Set<Integer> st = map.descendingKeySet();
        int idx = 0;

        for(Integer val : st) {
            ans[idx++] = map.get(val);
        }

        return ans;
    }
}
