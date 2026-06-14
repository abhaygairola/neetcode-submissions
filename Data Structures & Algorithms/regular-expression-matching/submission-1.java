class Solution {

    private Boolean[][] dp;

    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length() + 1][p.length() + 1];
        return dfs(0, 0, s, p);
    }

    private boolean dfs(int i, int j, String s, String p) {

        if (j == p.length()) {
            return i == s.length();
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        boolean firstMatch =
                i < s.length() &&
                (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        boolean ans;

        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {

            // Skip x*
            ans = dfs(i, j + 2, s, p);

            // Use one occurrence of x
            if (firstMatch) {
                ans |= dfs(i + 1, j, s, p);
            }

        } else {

            ans = firstMatch && dfs(i + 1, j + 1, s, p);
        }

        return dp[i][j] = ans;
    }
}