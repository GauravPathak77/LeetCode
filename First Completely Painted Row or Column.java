class Solution {
    private boolean isPainted(int[][] mat, int x, int y) {
        int idx = 0;
        
        for(idx = 0; idx < mat[0].length; idx++) {
            if(mat[x][idx] != -1) break;
        }

        if(idx == mat[0].length) return true;

        for(idx = 0; idx < mat.length; idx++) {
            if(mat[idx][y] != -1) break;
        }

        if(idx == mat.length) return true;

        return false;
    }

    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, int[]> map = new HashMap<>();

        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                map.put(mat[i][j], new int[] {i, j});
            }
        }

        for(int i = 0; i < arr.length; i++) {
            int[] pos = map.get(arr[i]);
            mat[pos[0]][pos[1]] = -1;
            if(isPainted(mat, pos[0], pos[1])) return i;
        }

        return -1;
    }
}
