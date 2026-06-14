class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int dp[][] = new int[n1][n2];
        for (int dps[] : dp) {
            Arrays.fill(dps, -1);
        }

        return dfs(n1 - 1, n2 - 1, word1, word2, dp);
    }

    private int dfs(int i, int j, String word1, String word2, int[][] dp) {
        if (i < 0)
            return j + 1;
        if (j < 0)
            return i + 1;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (word1.charAt(i) == word2.charAt(j)) {
            return dp[i][j] = dfs(i - 1, j - 1, word1, word2, dp);
        }

        int insert = 1 + dfs(i, j - 1, word1, word2, dp);
        int delete = 1 + dfs(i - 1, j, word1, word2, dp);
        int replace = 1 + dfs(i - 1, j - 1, word1, word2, dp);

        return dp[i][j] = Math.min(insert, Math.min(delete, replace));
    }
}
