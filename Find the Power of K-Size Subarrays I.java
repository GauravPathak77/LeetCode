class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int ans[] = new int[n-k+1];
        Arrays.fill(ans, -1);
        int i = 0;

        while(i + k <= n) {
            int j = i;
            while(j < i+k-1) {
                if(nums[j] != nums[j+1] - 1) break;
                j++;
            }
            if(j == i+k-1) ans[i] = nums[i+k-1];
            i++;
        }

        return ans;
    }
}
