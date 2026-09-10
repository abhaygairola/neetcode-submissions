class Solution {
    class TrieNode {
        HashMap<Character, TrieNode> children;
        boolean end;
        String word;

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
            cur.word = word;
            cur.end = true;
        }
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                dfs(board, r, c, res, root);
            }
        }
        return res;
    }

    void dfs(char[][] board, int r, int c, List<String> res, TrieNode cur) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] == '.'
            || !cur.children.containsKey(board[r][c])) {
            return;
        }
        cur = cur.children.get(board[r][c]);
        if (cur.end) {
            res.add(cur.word);
            cur.end = false; // important: avoid duplicates or use hashset
        }
        char temp = board[r][c];
        board[r][c] = '.';
        dfs(board, r + 1, c, res, cur);
        dfs(board, r - 1, c, res, cur);
        dfs(board, r, c + 1, res, cur);
        dfs(board, r, c - 1, res, cur);
        board[r][c] = temp;
    }
}
