class Solution {
    private long createPalindrome(long left, boolean isEven) {
        long res = isEven ? left : left/10;

        while(left > 0) {
            res = (res*10) + (left%10);
            left /= 10;
        }

        return res;
    }
    
    public String nearestPalindromic(String n) {
        int idx = n.length();
        boolean isEven = idx%2 == 0;
        String leftStr = isEven ? n.substring(0,idx/2) : n.substring(0,(idx/2)+1);
        Long left = Long.parseLong(leftStr);
        List<Long> cases = new ArrayList<>();
        String ans = " ";

        cases.add(createPalindrome(left, isEven));
        cases.add(createPalindrome(left+1, isEven));
        cases.add(createPalindrome(left-1, isEven));
        cases.add((long)Math.pow(10, idx-1)-1);
        cases.add((long)Math.pow(10, idx)+1);

        long minVal = Integer.MAX_VALUE;
        long num = cases.get(0);

        for(int i=0; i<cases.size(); i++) {
            Long diff = Math.abs(Long.valueOf(n) - cases.get(i));

            if(diff == 0) continue;

            if(diff == minVal) {
                num = Math.min(num, cases.get(i));
                ans = Long.toString(num);
            }
            else if(diff < minVal) {
                minVal = diff;
                num  = cases.get(i);
                ans = Long.toString(cases.get(i));
            }
        }

        return ans;
    }
}
