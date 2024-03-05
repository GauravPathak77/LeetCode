class Solution {
    public int minimumLength(String s) {
        int left = 0, right = s.length() - 1;
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            } else {
                while (left < right && s.charAt(left) == s.charAt(left + 1)) {
                    left++;
                }
                
                while (left < right && s.charAt(right) == s.charAt(right - 1)) {
                    right--;
                }
                
                left++;
                right--;
            }
        }
        
        return right < left ? 0 : (right - left + 1);
    }
}
