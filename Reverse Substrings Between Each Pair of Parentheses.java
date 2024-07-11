import java.util.Stack;

class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        
        for(char ch : s.toCharArray()) {
            if(ch == ')') {
                StringBuilder sb = new StringBuilder();
                while(!st.isEmpty() && st.peek() != '(') {
                    sb.append(st.pop());
                }
                st.pop();
                
                for(char c : sb.toString().toCharArray()) {
                    st.push(c);
                }
            } else {
                st.push(ch);
            }
        }
        
        StringBuilder result = new StringBuilder();
        for(char ch : st) {
            result.append(ch);
        }
        
        return result.toString();
    }
}
