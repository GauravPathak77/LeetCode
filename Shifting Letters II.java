class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] arr = new int[n + 1];

        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];
            int value = (direction == 1) ? 1 : -1;

            arr[start] += value;
            arr[end + 1] -= value;
        }

        int cumShift = 0;
        char[] res = s.toCharArray();
        for (int i = 0; i < n; i++) {
            cumShift += arr[i];
            int netShift = (cumShift % 26 + 26) % 26; 
            res[i] = (char) ((res[i] - 'a' + netShift) % 26 + 'a');
        }

        return new String(res);
    }
}
