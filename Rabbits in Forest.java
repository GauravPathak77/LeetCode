class Solution {
    public int numRabbits(int[] answers) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int ans : answers) {
            if(!map.containsKey(ans)) {
                map.put(ans, ans);
                res += ans + 1;
            }
            else {
                int val = map.get(ans);

                if(val > 0) map.put(ans, val-1);
                else {
                    map.put(ans, ans);
                    res += ans + 1;
                }
            }
        }

        return res;
    }
}
