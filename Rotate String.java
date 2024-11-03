class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if(ch == goal.charAt(0)) {
                list.add(i);
            }
        }

        if(list.size() == 1 && list.get(0) == s.length()) return false;

        for(int idx : list) {
            int i = idx;
            int j = 0;

            while(j < goal.length()) {
                if(s.charAt(i) != goal.charAt(j)) break;

                i = (i+1) % s.length();
                j++;
            }

            if(j == goal.length()) return true;
        }

        return false;
    }
}
