class Solution {
    class TrieNode {
        HashMap<Character, TrieNode> children;
        boolean end;

        public TrieNode() {
            end = false;
            children = new HashMap<>();
        }
    }
    TrieNode root;
    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        List<String> res = new ArrayList<>();
        for (String word : words) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                if (!cur.children.containsKey(c)) {
                    cur.children.put(c, new TrieNode());
                }
                cur = cur.children.get(c);
            }
            cur.end = true;
        }
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                dfs(board, r, c, res, "", root);
            }
        }
        return res;
    }

    void dfs(char[][] board, int r, int c, List<String> res, String path, TrieNode cur) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] == '.'
            || !cur.children.containsKey(board[r][c])) {
            return;
        }
        String s = path + board[r][c];
        cur = cur.children.get(board[r][c]);
        if (cur.end) {
            res.add(s);
            cur.end = false;
        }
        char temp = board[r][c];
        board[r][c] = '.';
        dfs(board, r + 1, c, res, s, cur);
        dfs(board, r - 1, c, res, s, cur);
        dfs(board, r, c + 1, res, s, cur);
        dfs(board, r, c - 1, res, s, cur);
        board[r][c] = temp;
    }
}
