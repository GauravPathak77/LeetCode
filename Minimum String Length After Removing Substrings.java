class Solution {
    public int minLength(String s) {

        while(s.contains("AB") || s.contains("CD")) {
            int idx1 = s.indexOf("AB");
            int idx2 = s.indexOf("CD");

            if(idx1 != -1 && idx2 != -1) {
                if(idx1 < idx2) {
                    s = s.substring(0,idx1) + s.substring(idx1+2);
                    s = s.substring(0, idx2-2) + s.substring(idx2+2-2);
                } else {
                    s = s.substring(0,idx2) + s.substring(idx2+2);
                    s = s.substring(0, idx1-2) + s.substring(idx1+2-2);
                }
            } else if (idx1 != -1) {
                s = s.substring(0,idx1) + s.substring(idx1+2);
            } else if (idx2 != -1) {
                s = s.substring(0,idx2) + s.substring(idx2+2);
            }
        }

        return s.length();
    }
}
