class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int minEle = Math.abs(matrix[0][0]);
        long totSum = 0;
        int negCount = 0;

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                minEle = Math.min(minEle, Math.abs(matrix[i][j]));
                totSum += Math.abs(matrix[i][j]);
                if(matrix[i][j] < 0) negCount++; 
            }
        }

        if(negCount % 2 == 0) return totSum;
        totSum -= 2*minEle;

        return totSum;
    }
}
