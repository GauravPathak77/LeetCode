class Solution {
    public String firstPalindrome(String[] words) {
        for(int i=0; i<words.length; i++){
            String str = words[i];
            if(isPallindrome(str)){
                return str;
            }
        }
        return "";
    }
    private boolean isPallindrome(String str){
        int n = str.length();
        for(int i=0, j=n-1; i<=j; i++, j--){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
