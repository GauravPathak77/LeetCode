class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int extraClosed = 0;

        for(char ch : s.toCharArray()) {
            if(ch == ')') {
                if(!st.isEmpty()) st.pop();
                else extraClosed++;
            } else st.push(ch);
        }

        return (st.size() + extraClosed);
    }
}
