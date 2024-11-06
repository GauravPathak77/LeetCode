class Solution {
    public boolean canSortArray(int[] nums) {
        Map<Integer, Integer> setBitMap = new HashMap<>();
        int n = nums.length;

        for(int num : nums) {
            int x = num;
            int countBit = 0;
            while(x > 0) {
                countBit += (x & 1);
                x = x >> 1;
            }
            setBitMap.put(num, countBit);
        }

        for(int turn = 0; turn < n-1; turn++) {
            for(int j = 0; j < n-turn-1; j++) {
                if(nums[j] > nums[j+1]) {
                    if(setBitMap.get(nums[j]) != setBitMap.get(nums[j+1])) return false;
                    else {
                        int temp = nums[j];
                        nums[j] = nums[j+1];
                        nums[j+1] = temp;
                    }
                }
            }
        }

        return true;
    }
}
