class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int dp[][] = new int [n][n];
        for(int dps[]:dp){
            Arrays.fill(dps,-1);
        }
        return dfs(0, n - 1, nums,dp);
    }
    private int dfs(int i, int j, int[] nums,int dp[][]) {
        if (i > j)
            return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int maxCoins = 0;
        for (int k = i; k <= j; k++) {
            int prev = (i - 1) < 0 ? 1 : nums[i - 1];
            int next = (j + 1 >= nums.length) ? 1 : nums[j + 1];

            maxCoins = Math.max(
                maxCoins, prev * nums[k] * next + dfs(i, k - 1, nums,dp) + dfs(k + 1, j, nums,dp));
        }
        return dp[i][j] = maxCoins;
    }
}
