class Solution {
    public String reversePrefix(String word, char ch) {
        int idx = -1;
        StringBuilder str = new StringBuilder(); 
        for(int i=0; i<word.length(); i++){
            if(word.charAt(i) == ch){
                idx = i;
                break;
            }
        }

        if(idx != -1){
            str.append(word.substring(0, idx+1));
            str.reverse();
            str.append(word.substring(idx+1));
            return str.toString();
        }
        return word;
    }
}
