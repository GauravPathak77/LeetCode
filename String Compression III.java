class Solution {
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        char[] arr = word.toCharArray();
        int freq = 1;

        for(int i = 1; i < arr.length; i++) {
            char ch1 = arr[i-1];
            char ch2 = arr[i];

            if(ch1 == ch2) freq++;
            else {
                if(freq <= 9) {
                    sb.append(freq).append(ch1);
                }
                else {
                    int n = 9;
                    while(freq > 0) {
                        sb.append(n).append(ch1);
                        freq = freq - n;
                        if(freq <= 9) n = freq; 
                    }
                }
                freq = 1;
            }
        }

        if(freq <= 9)
            sb.append(freq).append(arr[arr.length-1]);
        else {
            int n = 9;
            while(freq > 0) {
                sb.append(n).append(arr[arr.length-1]);
                freq = freq - n;
                if(freq <= 9) n = freq; 
                }
            }

        return sb.toString();
    }
}
