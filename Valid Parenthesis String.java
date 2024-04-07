
class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> left = new Stack<>();
        Stack<Integer> star = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(') left.push(i);
            else if(ch == '*') star.push(i);
            else {
                if(!left.isEmpty()) left.pop();
                else if(!star.isEmpty()) star.pop();
                else return false;
            }
        }

        while(left.size() != 0){
            if(star.size() == 0) return false;
            else if(star.peek() > left.peek()){
                star.pop();
                left.pop();
            } else{
                return false;
            }
        }
        return true;
    }
}
