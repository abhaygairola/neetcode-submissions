class Solution {
    public int maxProfit(int[] prices) {
        int n =prices.length;
        int dp[][]= new int[n][2];
        for(int dps[]:dp){
        Arrays.fill(dps,Integer.MAX_VALUE);}

        return dfs(prices, 0, true,dp);
    }

    private int dfs(int[] prices, int i, boolean allowBuy,int dp[][]) {
        int col = allowBuy?1:0;

        if (i >= prices.length)
            return 0;
        if (dp[i][col]!=Integer.MAX_VALUE)return dp[i][col];

        if (allowBuy) {
            return dp[i][col] = Math.max(-prices[i] + dfs(prices, i + 1, false,dp), dfs(prices, i + 1, true,dp));
        } else {
            return dp[i][col] = Math.max(prices[i] + dfs(prices, i + 2, true,dp), dfs(prices, i + 1, false,dp));
        }

    }
}