class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int ans = -1;

        for(int num : nums) {
            int temp = num;
            int sum = 0;
            while(temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }

            if(map.containsKey(sum)) {
                temp = map.get(sum);
                ans = Math.max(ans, num + temp);
            }

            map.put(sum, Math.max(num, temp));
        }

        return ans;
    }
}
