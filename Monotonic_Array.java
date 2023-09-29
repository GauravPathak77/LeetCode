class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean ans = true;
        if(nums[0]<nums[nums.length-1]){
            for(int i=1; i<nums.length; i++){
            if(nums[i] < nums[i-1]){
                return ans = false;
            }
        }
        }
        else{
           for(int i=1; i<nums.length; i++){
            if(nums[i] > nums[i-1]){
                return ans = false;
            }
        } 
        }
        return ans;
    }
}
