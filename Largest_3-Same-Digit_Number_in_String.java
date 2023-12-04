class Solution {
    public String largestGoodInteger(String num) {
        if(num.length() < 3){
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<num.length()-2; i++){
            if((num.charAt(i) == num.charAt(i+1)) && (num.charAt(i+1) == num.charAt(i+2))){
                if(sb.length() == 0 || num.charAt(i) > sb.charAt(0)){
                    sb.setLength(0);
                    sb.append(num.charAt(i));
                    sb.append(num.charAt(i));
                    sb.append(num.charAt(i));
                }
            }
        }
        return sb.toString();
    }
}
