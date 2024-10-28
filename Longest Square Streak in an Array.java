class Solution {
    public int longestSquareStreak(int[] nums) {
        Set<Integer> st = new HashSet<>();

        for (int num : nums) {
            st.add(num);
        }

        int maxStreak = 0;

        for (int num : nums) {
            int streak = 0;
            long curr = num;

            while (st.contains((int) curr)) {
                streak++;

                if (curr * curr > 1e5) {
                    break;
                }

                curr = curr * curr;
            }

            maxStreak = Math.max(maxStreak, streak);
        }

        return maxStreak < 2 ? -1 : maxStreak;
    }
}
