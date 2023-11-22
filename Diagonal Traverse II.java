class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> groups = new HashMap();
        int n = 0;
        for (int row = nums.size() - 1; row >= 0; row--) {
            for (int col = 0; col < nums.get(row).size(); col++) {

                if (!groups.containsKey(row + col)) {
                    groups.put(row + col, new ArrayList<Integer>());
                }

                groups.get(row + col).add(nums.get(row).get(col));
                n++;
            }
        }

        int[] result = new int[n];
        int i = 0;
        int diagonal = 0;

        while (groups.containsKey(diagonal)) {
            for (int num : groups.get(diagonal)) {
                result[i] = num;
                i++;
            }

            diagonal++;
        }

        return result;
    }
}
