class Solution {
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()){
            return new String();
        }

        int count = t.length();
        int []cnt = new int[128];
        for(char ch:t.toCharArray()){
            cnt[ch]++;
        }
        char []ch = s.toCharArray();

        int strt = 0, end = 0, min = Integer.MAX_VALUE, idx = 0;
        while(end < ch.length){
            if(cnt[ch[end++]]-- > 0){
                count--;
            }
            while(count == 0){
                if(end-strt < min){
                    idx = strt;
                    min = end-strt;
                }
                if(cnt[ch[strt++]]++ == 0){
                    count++;
                }
            }
        }

        return min == Integer.MAX_VALUE?new String():new String(ch, idx, min);
    }
}
