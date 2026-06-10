class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m][n];
        for (int[] dpf : dp) {
            Arrays.fill(dpf, -1);
        }

        return dfs(text1, text2, m-1, n-1, dp);
    }
    private int dfs(String text1, String text2, int m, int n, int[][] dp) {
        if (m < 0 || n < 0)
            return 0;
        if (dp[m][n] != -1)
            return dp[m][n];

        if (text1.charAt(m) == text2.charAt(n)) {
            return dp[m][n] = 1 + dfs(text1, text2, m - 1, n - 1, dp);
        }
        return dp[m][n] =
                   Math.max(dfs(text1, text2, m - 1, n, dp), dfs(text1, text2, m, n - 1, dp));
    }
}
