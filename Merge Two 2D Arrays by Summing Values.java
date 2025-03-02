class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
       Map<Integer, Integer> map = new HashMap<>();

       for(int[] nums : nums1) {
        map.put(nums[0], nums[1]);
       }

       for(int[] nums : nums2) {
        map.put(nums[0], map.getOrDefault(nums[0], 0) + nums[1]);
       }

       int[][] ans = new int[map.size()][2];

       int idx = 0;

       for(int key : map.keySet()) {
        ans[idx][0] = key;
        ans[idx][1] = map.get(key);
        idx++;
       }

       Arrays.sort(ans, (a,b) -> a[0] - b[0]);

       return ans;
    }
}
