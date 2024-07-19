class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        for(int[] row : matrix) {
            int min = Integer.MAX_VALUE;
            int idx = 0;
            for(int i=0; i<row.length; i++) {
                if(row[i] < min) {
                    min = row[i];
                    idx = i;
                }
            }

            if(isMaxColumn(matrix, min, idx)) ans.add(min);
        }

        return ans;
    }
    
    private boolean isMaxColumn(int[][] matrix, int min, int idx) {
        for(int[] row : matrix) {
            if(row[idx] > min) return false;
        }

        return true;
    }
}
