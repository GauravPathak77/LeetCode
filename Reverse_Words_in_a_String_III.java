class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0,j = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == ' '){
                int idx = i-1;
                while(idx >= j){
                    sb.append(s.charAt(idx));
                    idx--;
                }
                sb.append(" ");
                j = i+1;
            }
            else if(i == s.length()-1){
                int idx = i;
                while(idx >= j){
                    sb.append(s.charAt(idx));
                    idx--;
                }
            }
        }
        return sb.toString();
    }
}
