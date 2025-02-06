class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int ans = 0;

        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                int prod = nums[i] * nums[j];
                int freq = map.getOrDefault(prod, 0);

                ans += 8 * freq;

                map.put(prod, freq + 1);
            }
        }

        return ans;
    }
}
