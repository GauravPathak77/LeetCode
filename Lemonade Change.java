class Solution {
    public boolean lemonadeChange(int[] bills) {
        int countFive = 0;
        int countTen = 0;

        for(int bill : bills) {
            if(bill == 5) countFive++;
            else if(bill == 10) {
                if(countFive > 0) {
                    countFive--;
                    countTen++;
                } else return false;
            } else if(bill == 20) {
                if(countFive > 0 && countTen > 0) {
                    countFive--;
                    countTen--;
                } else if(countFive >= 3) {
                    countFive -= 3;
                }
                else return false;
            }
        }

        return true;
    }
}
