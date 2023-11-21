class Solution {
    final int M = 1000000007;;
    public int countNicePairs(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        int n = nums.length;        

        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] - revNum(nums[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = (int) ((ans + mp.getOrDefault(nums[i], 0)) % M);
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }

        return ans;
    }
    public int revNum(int num){
        int n = 0;
        while(num > 0){
            int r = num % 10;
            n = (n*10) + r;
            num /= 10;
        }
        System.out.println("Rev: " + n);
        return n;
    }
}
