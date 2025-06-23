class Solution {
    public long kMirror(int k, int n) {
        long sum = 0;
        int count = 0;
        int length = 1;

        while (count < n) {
            for (long pal : generatePalindromes(length)) {
                if (isPalindrome(Long.toString(pal, k))) {
                    sum += pal;
                    count++;
                    if (count == n) break;
                }
            }
            length++;
        }
        return sum;
    }

    private static List<Long> generatePalindromes(int length) {
        List<Long> res = new ArrayList<>();

        int half = (length + 1) / 2;
        long start = (long) Math.pow(10, half - 1);
        long end = (long) Math.pow(10, half);

        for (long i = start; i < end; i++) {
            String firstHalf = Long.toString(i);
            StringBuilder secondHalf = new StringBuilder(firstHalf);
            if (length % 2 == 1) {
                secondHalf.deleteCharAt(secondHalf.length() - 1);
            }
            String palindromeStr = firstHalf + secondHalf.reverse();
            res.add(Long.parseLong(palindromeStr));
        }

        return res;
    }

    private static boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}
