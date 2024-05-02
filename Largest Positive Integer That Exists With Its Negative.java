class Solution {
    public int findMaxK(int[] nums) {
        HashSet<Integer> map = new HashSet<>();
        int ans = -1;
        for(int num : nums){
            map.add(num);
            int k = num*(-1);
            if(map.contains(k)){
                ans = Math.max(ans,Math.abs(num));
            }
        }
        return ans;
    }
}
