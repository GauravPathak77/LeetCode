class Solution {
    private String ans;
    private void solve(int idx, int n, StringBuilder res, Set<String> numSet) {
        if(idx == n) {
            String str = res.toString();
            if(!numSet.contains(str)) ans = str;
            return;
        }

        if(ans.length() != 0) return;

        res.append('0');
        solve(idx+1, n, res, numSet);
        res.deleteCharAt(res.length() - 1);

        if(ans.length() != 0) return;
        
        res.append('1');
        solve(idx+1, n, res, numSet);
        res.deleteCharAt(res.length() - 1);
    }
    public String findDifferentBinaryString(String[] nums) {
        ans = "";
        Set<String> numSet = new HashSet<>();

        for(String num : nums) numSet.add(num);
        solve(0, nums.length, new StringBuilder(), numSet);
        return ans;
    }
}
