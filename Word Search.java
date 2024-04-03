
class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == word.charAt(0) && find(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;  
    }

    public boolean find(char[][] board, String word, int i, int j, int idx){
        int m = board.length;
        int n = board[0].length;

        if(idx == word.length()){
            return true;
        }

        if(i<0 || j<0 || i>=m || j>=n || board[i][j] == '$' || board[i][j] != word.charAt(idx)){
            return false;
        }

        board[i][j] = '$';
        if(find(board, word, i-1, j, idx+1) || find(board, word, i+1, j, idx+1) || find(board, word, i, j-1, idx+1) || find(board, word, i, j+1, idx+1))
            return true;

        board[i][j] = word.charAt(idx);
        return false;
    }
}
