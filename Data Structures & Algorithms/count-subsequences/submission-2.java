class Solution {
    public int numDistinct(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        int dp[][] = new int[n1 + 1][n2 + 1];
        for (int dps[] : dp) {
            Arrays.fill(dps, 0);
        }
        for (int i = 0; i <= n1; i++) {
            dp[i][n2] = 1;
        }

        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int take = 0;
                if (s.charAt(i) == t.charAt(j))
                    take = dp[i + 1][j + 1];
                int notTake = dp[i + 1][j];
                dp[i][j] = take + notTake;
            }
        }

        return dp[0][0];
    }

  
}
