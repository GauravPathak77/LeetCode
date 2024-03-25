class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        int size = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            size = Math.max(size, nums[i]);
        }

        int temp[] = new int[size+1];
        for(int i=0; i<nums.length; i++){
            temp[nums[i]]++;
        }
        for(int i=0; i<temp.length; i++){
            if(temp[i] == 2){
                ans.add(i);
            }
        }
        return ans;
    }
}
