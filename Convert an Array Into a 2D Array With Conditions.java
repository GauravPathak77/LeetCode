class Solution {
        public List<List<Integer>> findMatrix(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();

        for (int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        while (!map.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            Set<Integer> keys = new HashSet<>(map.keySet());

            for (Integer key : keys) {
                temp.add(key);
                if(map.containsKey(key)){
                    map.put(key, map.get(key) - 1);
                }
                if (map.get(key) == 0) {
                    map.remove(key);
                }
            }

            ans.add(temp);
        }
        return ans;
    }

}
