class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        int ans = -1;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            map.put(tops[i], map.getOrDefault(tops[i], 0) + 1);
            map.put(bottoms[i], map.getOrDefault(bottoms[i], 0) + 1);
        }

        int num = -1;
        for(int key : map.keySet()) {
            if(map.get(key) >= n) {
                num = key;
                break;
            }
        }

        boolean isValid = true;
        int topCount = 0;
        int bottomCount = 0;

        for(int i = 0; i < n; i++) {
            if(tops[i] != num && bottoms[i] != num) {
                isValid = false;
                break;
            }
            else if(tops[i] != num) topCount++;
            else if(bottoms[i] != num) bottomCount++;
        }

        if(isValid) {
            ans = Math.min(topCount, bottomCount);
        }

        return ans;
    }
}
