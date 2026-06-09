class Solution {
    public boolean canPartition(int[] nums) {
        int sums = sums(nums);
        if (sums % 2 != 0)
            return false;
        int[][] dp = new int[nums.length][sums/2+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return dfs(0, sums / 2, nums, dp);
    }
    private boolean dfs(int ind, int target, int[] nums, int[][] dp) {
        if (target == 0)
            return true;
        if (ind == nums.length)
            return false;
        if (dp[ind][target] != -1)
            return dp[ind][target] == 1;

        boolean tk = false;
        if (nums[ind] <= target) {
            tk = dfs(ind + 1, target - nums[ind], nums, dp);
        }
        boolean ntk = dfs(ind + 1, target, nums, dp);
        dp[ind][target] = (tk || ntk) ? 1 : 0;
        return (tk || ntk);
    }

    private int sums(int[] nums) {
        int tl = 0;
        for (int i = 0; i < nums.length; i++) {
            tl += nums[i];
        }
        return tl;
    }
}
