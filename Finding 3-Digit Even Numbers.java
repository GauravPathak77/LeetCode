class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int n = digits.length;
        Set<Integer> st = new HashSet<>();
        int freq[] = new int[10];

        for(int num : digits) freq[num]++;

        for(int i = 1; i <= 9; i++) {
            if(freq[i] == 0) continue;
            freq[i]--;
            for(int j = 0; j <= 9; j++) {
                if(freq[j] == 0) continue;
                freq[j]--;
                for(int k = 0; k <= 9; k++) {
                    if(freq[k] == 0) continue;
                    if(k % 2 != 0) continue;

                    int num = i * 100 + j * 10 + k;
                    st.add(num);
                }
                freq[j]++;
            }
            freq[i]++;
        }

        int[] ans = new int[st.size()];
        int idx = 0;

        for(int num : st) {
            ans[idx++] = num;
        }
        Arrays.sort(ans);

        return ans;
    }
}
