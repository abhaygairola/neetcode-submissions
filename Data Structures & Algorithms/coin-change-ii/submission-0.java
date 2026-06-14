class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n][amount + 1];
        for(int dps[]:dp){
            Arrays.fill(dps,-1);
        }
        return dfs(coins.length - 1, amount, coins, dp);
    }

    private int dfs(int ind, int amount, int[] coins, int dp[][]) {
        if (dp[ind][amount] != -1) {
            return dp[ind][amount];
        }
        if (ind == 0) {
            return dp[ind][amount] = amount % coins[ind] == 0 ? 1 : 0;
        }
        int n = coins.length;
        int take = 0, nottake = 0;
        if (coins[ind] <= amount)
            take = dfs(ind, amount - coins[ind], coins, dp);
        nottake = dfs(ind - 1, amount, coins, dp);
        return dp[ind][amount] = take + nottake;
    }
}
