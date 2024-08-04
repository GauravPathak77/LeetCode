class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> subarraySums = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                subarraySums.add(sum);
            }
        }
        
        Collections.sort(subarraySums);
        
        long result = 0;
        int mod = 1000000007;
        for (int i = left - 1; i < right; i++) {
            result = (result + subarraySums.get(i)) % mod;
        }
        
        return (int) result;
    }
}
