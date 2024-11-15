class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int ans = 0;

        int left = 0;
        while(left < n-1 && arr[left] <= arr[left+1]) {
            left++;
        }

        if(left == n-1) return 0;

        int right = n-1;

        while(right > 0 && arr[right] >= arr[right-1]) {
            right--;
        }

        ans = Math.min(n-1-left, right);

        int i = 0, j = right;
        while(i <= left && j <= n-1) {
            if(arr[i] <= arr[j]) {
                ans = Math.min(ans, j-i-1);
                i++;
            } else {
                j++;
            }
        }

        return ans;
    }
}
