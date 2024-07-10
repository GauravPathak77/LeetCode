class Solution {
    public int minOperations(String[] logs) {
        Stack<String> st = new Stack<>();

        for(String opt : logs) {
            if(opt.equals("./")) continue;
            else if(opt.equals("../")) {
                if(!st.isEmpty()) st.pop();
            }
            else st.push(opt);
        }

        return st.size();
    }
}
