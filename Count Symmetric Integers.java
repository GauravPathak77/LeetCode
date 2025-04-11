class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int ans = 0;

        while(low <= high) {
            String str = String.valueOf(low);
            int n = str.length();
            
            if(n % 2 == 0) {
                long sumStart = 0;
                long sumEnd = 0;

                for(int i = 0, j = n-1; i < n / 2; i++, j--) {
                    sumStart += Character.getNumericValue(str.charAt(i));
                    sumEnd += Character.getNumericValue(str.charAt(j)); 
                }

                if(sumStart == sumEnd) ans++;
            }

            low++;
        }

        return ans;
    }
}
