class Solution {
    public int takeCharacters(String s, int k) {
        int n = s.length();
        int countA = 0, countB = 0, countC = 0;

        for (char ch : s.toCharArray()) {
            if(ch == 'a') countA++;
            else if(ch == 'b') countB++;
            else if(ch == 'c') countC++;
        }

        if (countA < k || countB < k || countC < k) {
            return -1;
        }

        int newCountA = 0, newCountB = 0, newCountC = 0;
        int maxWindow = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            char ch1 = s.charAt(right);
            if(ch1 == 'a') newCountA++;
            else if(ch1 == 'b') newCountB++;
            else if(ch1 == 'c') newCountC++;

            while (newCountA > countA - k || newCountB > countB - k || newCountC > countC - k) {
                int ch2 = s.charAt(left);
                if(ch2 == 'a') newCountA--;
                else if(ch2 == 'b') newCountB--;
                else if(ch2 == 'c') newCountC--;

                left++;
            }

            maxWindow = Math.max(maxWindow, right - left + 1);
        }

        return n - maxWindow;
    }
}
