class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n];
        for (int dps[] : dp) {
            Arrays.fill(dps, 0);
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (i > j) continue;
                int maxCoins = 0;
                for (int k = i; k <= j; k++) {
                    int prev = (i - 1) < 0 ? 1 : nums[i - 1];
                    int next = (j + 1 >= nums.length) ? 1 : nums[j + 1];

                    maxCoins =
                        Math.max(maxCoins, prev * nums[k] * next + ((k - 1<0)?0:dp[i][k - 1]) + ((k + 1>=n)?0:dp[k + 1][j]));
                }
                dp[i][j] = maxCoins;
            }
        }

        return dp[0][n-1];
    }
    
}
