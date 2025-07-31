class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> prev = new HashSet<>();

        for(int num : arr) {
            Set<Integer> curr = new HashSet<>();
            curr.add(num);

            for(int x : prev) {
                curr.add(x | num);
            }

            result.addAll(curr);
            prev = curr;
        }

        return result.size();
        
    }
}
