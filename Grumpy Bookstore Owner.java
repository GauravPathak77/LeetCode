class Solution {
    public int maxSatisfied(int[] cust, int[] grumpy, int minutes) {
        int res = 0, curr = 0;
        
        for (int i = 0; i < cust.length; ++i) {
            if (grumpy[i] == 0) {
                res += cust[i];
            }
        }
        
        for (int i = 0; i < minutes; ++i) {
            if (grumpy[i] == 1) {
                curr += cust[i];
            }
        }
        
        int addi = curr; 

        for (int i = minutes; i < cust.length; ++i) {
            if (grumpy[i -minutes] == 1) {
                curr -= cust[i - minutes];
            }
            if (grumpy[i] == 1) {
                curr += cust[i];
            }

            addi = Math.max(addi, curr);
        }
        
        return res + addi; 
    }
}
