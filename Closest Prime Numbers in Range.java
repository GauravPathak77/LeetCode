class Solution {
    public int[] closestPrimes(int left, int right) {
        List<Integer> list = new ArrayList<>();
        int[] ans = new int[]{-1, -1};

        for(int num = left; num <= right; num++) {
            if(isPrime(num)) list.add(num);
        }

        for(int i = 1; i < list.size(); i++) {
            int num1 = list.get(i-1);
            int num2 = list.get(i);

            if(ans[0] == -1) {
                ans[0] = num1;
                ans[1] = num2;
            } 
            else if(num2 - num1 < ans[1] - ans[0]) {
                ans[0] = num1;
                ans[1] = num2;
            }
        }

        return ans;
    }

    private boolean isPrime(int n) {
        if(n == 2) return true;
        if(n < 2 || n % 2 == 0) return false;

        for(int i = 3; i <= Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }

        return true;
    }
}
