class Solution {
    public int countHillValley(int[] nums) {
        List<Integer> clean = new ArrayList<>();
        clean.add(nums[0]);
        
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i - 1]) {
                clean.add(nums[i]);
            }
        }

        int count = 0;
        for(int i = 1; i < clean.size() - 1; i++) {
            if((clean.get(i) > clean.get(i - 1) && clean.get(i) > clean.get(i + 1)) || 
                (clean.get(i) < clean.get(i - 1) && clean.get(i) < clean.get(i + 1))) {
                count++;
            }
        }

        return count;
    }
}
