class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int currProd = 1, left = 0, right = 0, len = nums.length;
        int subArrCnt = 0;
        while(right < len){
            currProd *= nums[right];
            while(currProd >= k && left <= right){
                currProd /= nums[left++];
            }
            if(left <= right)
                subArrCnt+= right - left + 1;
            right++;
        }
        return subArrCnt;
    }
}
