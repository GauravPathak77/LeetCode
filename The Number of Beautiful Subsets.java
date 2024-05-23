class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        return beautifulUtil(nums, k, 0, list);
    }

    public int beautifulUtil(int[] nums, int k, int idx, List<Integer> list){
        if(idx == nums.length){
            return 0;
        }

        int take = 0;
        if(isValid(list, nums[idx], k)){
            list.add(nums[idx]);
            take = 1 + beautifulUtil(nums, k, idx+1, list);
            list.remove(list.size()-1);
        }

        int notTake = 0 + beautifulUtil(nums, k, idx+1, list);

        return take + notTake;
        
    }

    public boolean isValid(List<Integer> list, int num, int k){
        for(int i =0; i<list.size(); i++){
            if(Math.abs(num - list.get(i)) == k){
                return false;
            }
        }

        return true;
    }
}
