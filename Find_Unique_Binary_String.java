class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder s = new StringBuilder();
        for(int i=0; i<nums.length; i++){
            char ch = nums[i].charAt(i);
            ch = (ch == '0') ? '1' : '0';
            s.append(ch);
        }
        return s.toString();
    }
}
