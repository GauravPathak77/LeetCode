class Solution {
    public int minimumOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int ans = 0;

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            list.add(num);
        }

        List<Integer> toRemove = new ArrayList<>();
        for(int key : map.keySet()) {
            if (map.get(key) == 1) {
                toRemove.add(key);
            }
        }
        for(int key : toRemove) {
            map.remove(key);
        }

        while(map.size() != 0) {
            ans++;
            if(list.size() < 3) break;

            int x = list.remove(0);
            int y = list.remove(0);
            int z = list.remove(0);

            for(int val : new int[]{x, y, z}) {
                if(map.containsKey(val)) {
                    map.put(val, map.get(val) - 1);
                    
                    if(map.get(val) == 1) {
                        map.remove(val);
                    }
                }
            }
        }

        return ans;
    }
}
