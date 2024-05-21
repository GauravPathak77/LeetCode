class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        subsetsUtil(nums, temp, 0, nums.length, ans);
        return ans;
    }

    private void subsetsUtil(int[] nums, List<Integer> temp, int i, int n, List<List<Integer>> ans) {
        if (i >= n) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[i]);
        subsetsUtil(nums, temp, i + 1, n, ans);

        temp.remove(temp.size() - 1);
        subsetsUtil(nums, temp, i + 1, n, ans);
    }
}
