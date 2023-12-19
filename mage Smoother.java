class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = getSmoothedValue(img, i, j, m, n);
            }
        }

        return result;
    }

    private int getSmoothedValue(int[][] img, int row, int col, int m, int n) {
        int sum = 0;
        int count = 0;

        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (isValidCell(i, j, m, n)) {
                    sum += img[i][j];
                    count++;
                }
            }
        }

        return sum / count;
    }

    private boolean isValidCell(int row, int col, int m, int n) {
        return row >= 0 && row < m && col >= 0 && col < n;
    }

}
