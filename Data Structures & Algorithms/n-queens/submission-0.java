class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] c : board) {
            Arrays.fill(c, '.');
        }
        dfs(0, new HashSet(), new HashSet(), new HashSet(), n, board, res);
        return res;
    }
    void dfs(int r, Set<Integer> col, Set<Integer> pdiag, Set<Integer> ndiag, int n,
        char[][] board, List<List<String>> res) {
        if (r == n) {
            List<String> cur = new ArrayList<>();
            for (char[] c : board) {
                cur.add(new String(c));
            }
            res.add(cur);
            return;
        }

        for (int c = 0; c < n; c++) {
            if (col.contains(c) || pdiag.contains(r+c) || ndiag.contains(r-c)) {
                continue;
            }

            col.add(c);
            pdiag.add(r+c);
            ndiag.add(r-c);
            board[r][c] = 'Q';
            dfs(r+1, col, pdiag, ndiag, n, board, res);
            col.remove(c);
            pdiag.remove(r+c);
            ndiag.remove(r-c);
            board[r][c] = '.';
        }
    }
}
