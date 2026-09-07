class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        dfs(n, 0, 0, res, cur, 0);
        return res;
    }
    void dfs(int n, int open, int close, List<String> res, StringBuilder cur, int ind) {
        if (cur.length() == 2 * n) {
            res.add(cur.toString());
            return;
        }

        if (open < n) {
            cur.append('(');
            dfs(n, open+1, close, res, cur, ind + 1);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            dfs(n, open, close+1, res, cur, ind + 1);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
