class Solution {
    public int maximum69Number (int num) {
        String str = Integer.toString(num);
        int idx = str.indexOf("6");
        if(idx == -1) return num;

        String temp = str.substring(0, idx) + "9" + str.substring(idx+1);
        return Integer.parseInt(temp);   
    }
}
