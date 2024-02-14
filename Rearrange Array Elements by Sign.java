class Solution {
    public int[] rearrangeArray(int[] nums) {
        ArrayList<Integer> positiveList = new ArrayList<>();
        ArrayList<Integer> negativeList = new ArrayList<>();
        int i=0;
        for(i=0; i<nums.length; i++){
            if(nums[i] >= 0){
                positiveList.add(nums[i]);
            }else{
                negativeList.add(nums[i]);
            }
        }
        i=0;
        int idx = 0;
        while(idx < positiveList.size()){
            nums[i] = positiveList.get(idx);
            idx++;
            i += 2;
        }
        i=1;
        idx = 0;
        while(idx < negativeList.size()){
            nums[i] = negativeList.get(idx);
            idx++;
            i += 2;
        }
        return nums;
    }
}
