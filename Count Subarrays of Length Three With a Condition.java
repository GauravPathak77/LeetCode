class Solution {
    public int countSubarrays(int[] nums) {
        int n = nums.length;
        int[] arr = new int[3];
        int ans = 0;

        for(int i = 0; i < 3; i++) {
            arr[i] = nums[i];
        }

        if(arr[0] + arr[2] == arr[1] / 2.0) ans++;

        for(int i = 3; i < n; i++) {
            arr[0] = arr[1];
            arr[1] = arr[2];
            arr[2] = nums[i];

            if(arr[0] + arr[2] == arr[1] / 2.0) ans++;
        }

        return ans;
    }
}
