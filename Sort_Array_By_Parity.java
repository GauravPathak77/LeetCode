class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int idx = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]%2 == 0 && i!= 0){
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
                idx++;
            }
            else if(nums[i]%2 == 0){
                idx++;
            }
        }
        return nums;
    }
}
