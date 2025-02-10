class Solution {
    public String clearDigits(String s) {
        List<Character> list = new ArrayList<>();
        
        for(int i=0; i<s.length(); i++){
            list.add(s.charAt(i));
        }
        
        for(int i=0; i<list.size(); i++){
            Character ch = list.get(i);
            if(Character.isDigit(ch)){
                list.remove(i);
                i--;
                if(i>=0){
                    list.remove(i);
                    i--;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<list.size(); i++){
            sb.append(list.get(i));
        }
        return sb.toString();
    }
}
