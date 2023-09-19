class Solution {
    public int findDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                ans = nums[i];
                break;
            }
            map.put(nums[i], 0);
        }
        return ans;
    }
}
