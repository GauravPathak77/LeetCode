class Solution {
    public int minBitFlips(int start, int goal) {
        String startString = Integer.toBinaryString(start);
        String goalString = Integer.toBinaryString(goal);
        int ans = 0;

        if(startString.length() != goalString.length()) {
            StringBuilder sb = new StringBuilder();
            int extralength = Math.abs(startString.length() - goalString.length());
            for(int i=0; i<extralength; i++) {
                sb.append('0');
            }

            if(startString.length() < goalString.length()) {
                startString = sb.toString() + startString;
            } else {
                goalString = sb.toString() + goalString;
            }
        }

        for(int i=0; i<startString.length(); i++) {
            if(startString.charAt(i) != goalString.charAt(i)) {
                ans++;
            }
        }

        return ans;
    }
}
