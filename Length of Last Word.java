class Solution {
    public int lengthOfLastWord(String s) {
        int ans = 0;
        int n = s.length();
        while(s.charAt(n-1) == ' '){
            n--;
        }
        for(int i=n-1; i>=0; i--){
            if(s.charAt(i) == ' '){
                ans = (n-1) - i;
                break;
            }
        }
        if(ans == 0 && n != 0){
            ans = n;
        }
        return ans;
    }
}
