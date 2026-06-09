class Solution {
    public boolean canPartition(int[] nums) {
        int sums = sums(nums);
        if (sums % 2 != 0)
            return false;
        int n = nums.length;
        int k = sums / 2;
        boolean[][] dp = new boolean[n][k + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if (nums[0] <= k + 1)
            dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                boolean ntk = dp[i - 1][j];
                boolean tk = false;
                if (nums[i] <= j) {
                    tk = dp[i-1][j-nums[i]];
                }

                dp[i][j] = (tk || ntk) ;
                }
        }

        return dp[n-1][k];
    }

    private int sums(int[] nums) {
        int tl = 0;
        for (int i = 0; i < nums.length; i++) {
            tl += nums[i];
        }
        return tl;
    }
}
