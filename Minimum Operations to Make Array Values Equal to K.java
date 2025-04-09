class Solution {
    public int minOperations(int[] nums, int k) {
        TreeSet<Integer> ts = new TreeSet<>();

        for(int num : nums) ts.add(num);
        int minEle = ts.pollFirst();
        ts.add(minEle);

        if(minEle == k) return ts.size() - 1;
        if(minEle > k) return ts.size();
        return -1;
    }
}
