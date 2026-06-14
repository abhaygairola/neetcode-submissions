class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n][amount + 1];
        for (int a = 0; a <= amount; a++) {
            dp[0][a] = a % coins[0] == 0 ? 1 : 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                int take = 0, nottake = 0;
                if (coins[i] <= j)
                    take = dp[i][j - coins[i]];
                nottake = dp[i - 1][j];
                dp[i][j] = take + nottake;
            }
        }

        return dp[n - 1][amount];
    }
}
