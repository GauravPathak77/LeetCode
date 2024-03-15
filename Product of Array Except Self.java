class Solution {
    public int[] productExceptSelf(int[] nums) {
        int answer[] = new int[nums.length];
       int totalProduct = 1;
       int isZero = 0;
       for(int i=0; i<nums.length; i++){
        if(nums[i] == 0){
            isZero++;
        } else{
            totalProduct = totalProduct * nums[i];
        }
       }

       if(isZero == nums.length || isZero > 1){
        return answer;
       }

       for(int i=0; i<nums.length; i++){
        if(isZero != 0 && nums[i] != 0){
            answer[i] = 0;
        }
        else if(nums[i] == 0){
            answer[i] = totalProduct;
        }
        else{
            answer[i] = (int)(totalProduct/nums[i]);
        }
       }

       return answer;
    }
}
