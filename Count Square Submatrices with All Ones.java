class Solution {
    private Boolean memo[][][];
    private boolean isAllOnes(int[][] matrix, int row, int col, int size) {
        if(memo[row][col][size] != null) return memo[row][col][size];
        for(int i = row; i < row+size; i++) {
            for(int j = col; j < col+size; j++) {
                if(matrix[i][j] == 0) {
                    memo[row][col][size] = false;
                    return false;
                }
            }
        }

        memo[row][col][size] = true;
        return true;
    }
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 0;

        memo = new Boolean[m][n][Math.min(m, n)+1];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                for(int size = 1; i+size <= m && j+size <= n; size++) {
                    if(isAllOnes(matrix, i, j, size)) ans++;
                    else break;
                }
            }
        }

        return ans;
    }
}
