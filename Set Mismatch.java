class Solution {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int result[] = new int[2];
        int n = nums.length;
        int sum = 0;

        for(int i=1; i<=n; i++){
            sum += i - nums[i-1];
            if(i < n && nums[i-1] == nums[i]){
                result[0] = nums[i-1];
            }
        }

        result[1] = sum + result[0];

        return result;
    }
}
