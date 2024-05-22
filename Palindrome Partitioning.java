class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        
        backtrack(0, s, path, result);
        return result;
    }
    
    private void backtrack(int start, String s, List<String> path, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int end = start + 1; end <= s.length(); ++end) {
            String substr = s.substring(start, end);
            if (isPalindrome(substr)) {
                path.add(substr);
                backtrack(end, s, path, result);
                path.remove(path.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
