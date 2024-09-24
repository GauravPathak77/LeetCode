class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> st = new HashSet<>();
        int ans = 0;

        for(int num : arr1) {
            String str = Integer.toString(num);
            for(int i = 1; i <= str.length(); i++) {
                int n = Integer.parseInt(str.substring(0, i));
                st.add(n);
            }
        }

        for(int num : arr2) {
            String str = Integer.toString(num);
            for(int i = 1; i <= str.length(); i++) {
                int n = Integer.parseInt(str.substring(0, i));
                if(st.contains(n)) {
                    int digits = (int)(Math.log10(n) + 1);
                    ans = Math.max(ans, digits);
                }
            }
        }

        return ans;
    }
}
