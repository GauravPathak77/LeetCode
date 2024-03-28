import java.util.HashMap;

public class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int j = 0;
        int res = 0;
        HashMap<Integer, Integer> M = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            M.put(nums[i], M.getOrDefault(nums[i], 0) + 1);
            
            while (M.get(nums[i]) > k) {
                M.put(nums[j], M.get(nums[j]) - 1);
                j++;
            }
            
            res = Math.max(res, i - j + 1);
        }
        
        return res;
    }
}
