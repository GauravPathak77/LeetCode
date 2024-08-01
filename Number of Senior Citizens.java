class Solution {
    public int countSeniors(String[] details) {
        int ans = 0;
        for(String pass : details) {
            Integer age = Integer.valueOf(pass.substring(11, 13));
            if(age > 60) ans++;
        }
        return ans;
    }
}
