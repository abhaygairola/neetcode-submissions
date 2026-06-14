class Solution {
    public int numDistinct(String s, String t) {
        int dp[][] = new int [s.length()][t.length()];
        for (int dps[] : dp) {
            Arrays.fill(dps, -1);
        }
        return dfs(0, 0, s, t, dp);
    }

    private int dfs(int i, int j, String s, String t, int dp[][]) {
        int n1 = s.length();
        int n2 = t.length();
        if (j == n2)
            return 1;
        if (i == n1)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int take = 0;
        if (s.charAt(i) == t.charAt(j))
            take = dfs(i + 1, j + 1, s, t, dp);
        int notTake = dfs(i + 1, j, s, t, dp);
        return dp[i][j] = take + notTake;
    }
}
