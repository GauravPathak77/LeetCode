class Solution {
    private int ans = 0;

    public int maximumGain(String s, int x, int y) {
        List<Character> list = new ArrayList<>();

        for (Character ch : s.toCharArray()) {
            list.add(ch);
        }

        if (x > y) {
            list = maximumGainUtil(list, x, 'a', 'b');
            list = maximumGainUtil(list, y, 'b', 'a');
        } else {
            list = maximumGainUtil(list, y, 'b', 'a');
            list = maximumGainUtil(list, x, 'a', 'b');
        }

        return ans;
    }

    public List<Character> maximumGainUtil(List<Character> list, int currVal, char n1, char n2) {
        int i = 0;
        while (i < list.size() - 1) {
            if (list.get(i) == n1 && list.get(i + 1) == n2) {
                ans += currVal;
                list.remove(i);
                list.remove(i);
                i = Math.max(i - 1, 0);
            } else {
                i++;
            }
        }

        return list;
    }
}
