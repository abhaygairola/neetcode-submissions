class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(s, res, new ArrayList<>(), 0);
        return res;
    }

    void dfs(String s, List<List<String>> res, List<String> cur, int ind) {
        if (ind >= s.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = ind; i < s.length(); i++) {
            if (isPal(s, ind, i)) {
                cur.add(s.substring(ind, i + 1));
                dfs(s, res, cur, i + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }
    boolean isPal(String s, int i, int j) {
        for (int k = 0; k < (j - i) / 2 + 1; k++) {
            if (s.charAt(i + k) != s.charAt(j - k))
                return false;
        }
        return true;
    }
}
