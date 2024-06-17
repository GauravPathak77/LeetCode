class Solution {
    public boolean judgeSquareSum(int c) {
        long num = 0, res = (long)Math.sqrt(c);
        while (num <= res) {
            if (num * num + res * res == c){
                return true;
            }
            if (num * num + res * res > c){
                res--;
            }
            else num++;
        }
        return false;
    }
}
