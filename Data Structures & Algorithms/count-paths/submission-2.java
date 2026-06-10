class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] dpf : dp) {
            Arrays.fill(dpf, -1);
        }
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int down = (j - 1 >= 0) ? dp[i][j - 1] : 0;
                int right = (i - 1 >= 0) ? dp[i - 1][j] : 0;
                dp[i][j] = down + right;
            }
        }
        return dp[m - 1][n - 1];
    }

    int dfs(int i, int j, int m, int n, int[][] dp) {
        if (i == m && j == n) {
            return 1;
        }
        if (i > m || j > n) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int down = dfs(i, j + 1, m, n, dp);
        int right = dfs(i + 1, j, m, n, dp);
        return dp[i][j] = down + right;
    }
}
