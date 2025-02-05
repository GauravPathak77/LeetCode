class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) return true;

        int n = s1.length();
        List<Integer> diff = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff.add(i);
            }
            if (diff.size() > 2) return false;
        }

        return diff.size() == 2 &&
               s1.charAt(diff.get(0)) == s2.charAt(diff.get(1)) &&
               s1.charAt(diff.get(1)) == s2.charAt(diff.get(0));
    }
}
