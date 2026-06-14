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
                maxPath = Math.max(maxPath, dfs(i, j, matrix,dp));
            }
        }
        return maxPath;
    }

    private int dfs(int i, int j, int[][] matrix, int dp[][]) {
        int r = matrix.length;
        int c = matrix[0].length;
        if (i < 0 || i > r - 1 || j < 0 || j > c - 1)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int top = 0, right = 0, left = 0, bottom = 0;
        if (i > 0 && matrix[i][j] < matrix[i - 1][j])
            top = 1 + dfs(i - 1, j, matrix, dp);
        if (i < r - 1 && matrix[i][j] < matrix[i + 1][j])
            bottom = 1 + dfs(i + 1, j, matrix, dp);
        if (j > 0 && matrix[i][j] < matrix[i][j - 1])
            left = 1 + dfs(i, j - 1, matrix, dp);
        if (j < c - 1 && matrix[i][j] < matrix[i][j + 1])
            right = 1 + dfs(i, j + 1, matrix, dp);

        return dp[i][j] = Math.max(1, Math.max(top, Math.max(bottom, Math.max(left, right))));
    }
}
