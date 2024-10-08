class Solution {
    public int minSwaps(String s) {
        int imbalance = 0;
        int swap = 0;

        for(int i = 0; i < s.length()-1; i++) {
            char ch = s.charAt(i);

            if(ch == '[') {
                imbalance--;
            } else {
                imbalance++;
            }

            if(imbalance > 0) {
                imbalance -= 2;
                swap++;
            }
        }

        return swap; 
    }
}
