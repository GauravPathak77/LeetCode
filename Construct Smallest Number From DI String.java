class Solution {
    private String result = null;
    
    private void solve(int idx, boolean[] used, StringBuilder nums, String pattern) {
        int n = pattern.length();
        
        if(idx == n + 1) {
            String numStr = nums.toString();
            if(result == null || numStr.compareTo(result) < 0) {
                result = numStr;
            }
            return;
        }

        for(int i = 1; i <= 9; i++) {
            if(!used[i]) {
                if(idx == 0 || (pattern.charAt(idx - 1) == 'I' && nums.charAt(idx - 1) - '0' < i) ||
                        (pattern.charAt(idx - 1) == 'D' && nums.charAt(idx - 1) - '0' > i)) {
                    
                    used[i] = true;
                    nums.append(i);
                    
                    solve(idx + 1, used, nums, pattern);
                    
                    nums.deleteCharAt(nums.length() - 1);
                    used[i] = false;
                }
            }
        }
    }

    public String smallestNumber(String pattern) {
        result = null;
        boolean[] used = new boolean[10];
        solve(0, used, new StringBuilder(), pattern);
        return result;
    }
}
