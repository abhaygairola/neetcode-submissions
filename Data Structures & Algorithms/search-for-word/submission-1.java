class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (dfs(r, c, board, word, 0))
                    return true;
            }
        }
        return false;
    }

    boolean dfs(int r, int c, char[][] board, String word, int ind) {
        if (ind == word.length())
            return true;
        int row = board.length;
        int col = board[0].length;
        if (r < 0 || c < 0 || r > row - 1 || c > col - 1 || board[r][c] == '#'
            || word.charAt(ind) != board[r][c]) {
            return false;
        }
        char temp = board[r][c];
        board[r][c] = '#';
        boolean res = dfs(r, c - 1, board, word, ind + 1)||
        dfs(r, c + 1, board, word, ind + 1)||
        dfs(r + 1, c, board, word, ind + 1)||
        dfs(r - 1, c, board, word, ind + 1);
        board[r][c] = temp;
        return res;
    }
}
