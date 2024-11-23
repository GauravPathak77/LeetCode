class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int n = box.length;
        int m = box[0].length;
        char ans[][] = new char[m][n];

        for(int i = 0; i < n; i++) {
            int idx = m-1;
            for(int j = m-1; j >= 0 && idx >= 0; j--) {
                if(box[i][j] == '*') {
                    idx = j - 1;
                } else if(box[i][j] == '#') {
                    char tmp = box[i][j];
                    box[i][j] = box[i][idx];
                    box[i][idx] = tmp;
                    idx--;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                ans[j][n - 1 - i] = box[i][j];
            }
        }

        return ans;
    }
}
