class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n];

        for(int i = 0; i < n; i++) {
            Set<Integer> st = new HashSet<>();
            for(int j = 0; j <= i; j++) {
                st.add(A[j]);
            }
            int count = 0;
            for(int j = 0; j <= i; j++) {
                if(st.contains(B[j])) count++;
            }
            ans[i] = count;
        }

        return ans;
    }
}
