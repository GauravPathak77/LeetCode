class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for(Integer key : map.keySet()){
            int num = map.get(key);

            if(num == 1){
                return -1;
            }
            int r = num % 3;

            if(num % 3 == 1){
                ans += num/3 - 1;
                num -= 3*(num/3 - 1);
            }
            else{
                ans += num/3;
                num = num % 3;
            }
            if(num > 0){
                if(num % 2 == 0){
                    ans += num/2;
                }
                else{
                    return -1;
                }
            }
        }
        return ans;
    }
}
