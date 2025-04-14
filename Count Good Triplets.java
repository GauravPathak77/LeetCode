class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n = arr.length;
        int ans = 0;
        LinkedHashSet<int[]> st = new LinkedHashSet<>();

        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                if(Math.abs(arr[i] - arr[j]) <= a) st.add(new int[] {i, j});
            }
        }

        for(int k = 2; k < n; k++) {
            for(int[] temp : st) {
                if(k <= temp[1]) continue;
                if(Math.abs(arr[temp[1]] - arr[k]) <= b && Math.abs(arr[temp[0]] - arr[k]) <= c) ans++;
            }
        }

        return ans;
    }
}
