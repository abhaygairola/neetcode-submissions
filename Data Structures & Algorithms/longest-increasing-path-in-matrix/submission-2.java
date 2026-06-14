class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int maxPath = 0;
        int r = matrix.length;
        int c = matrix[0].length;
        int dp[][] = new int[r][c];
        for (int dps[] : dp) {
            Arrays.fill(dps, -1);
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                maxPath = Math.max(maxPath, dfs(i, j, matrix, dp));
            }
        }
        return maxPath;
    }

    private int dfs(int i, int j, int[][] matrix, int dp[][]) {
        int r = matrix.length;
        int c = matrix[0].length;
        if (dp[i][j] != -1)
            return dp[i][j];
        int ans = 1;

        if (i > 0 && matrix[i][j] < matrix[i - 1][j])
            ans = Math.max(ans, 1 + dfs(i - 1, j, matrix, dp));

        if (i < r - 1 && matrix[i][j] < matrix[i + 1][j])
            ans = Math.max(ans, 1 + dfs(i + 1, j, matrix, dp));

        if (j > 0 && matrix[i][j] < matrix[i][j - 1])
            ans = Math.max(ans, 1 + dfs(i, j - 1, matrix, dp));

        if (j < c - 1 && matrix[i][j] < matrix[i][j + 1])
            ans = Math.max(ans, 1 + dfs(i, j + 1, matrix, dp));

        return dp[i][j] = ans;
    }
}
