class Solution {
    private void findCombinations(int idx, int n, int[] arr, int target, List<Integer> ds, List<List<Integer>> ans) {
        if(target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=idx; i<n; i++) {
            if(i > idx && arr[i] == arr[i-1]) continue;
            if(arr[i] > target) continue;

            ds.add(arr[i]);
            findCombinations(i+1, n, arr, target-arr[i], ds, ans);
            ds.remove(ds.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, candidates.length, candidates, target, new ArrayList<>(), ans);
        return ans;
    }
}
