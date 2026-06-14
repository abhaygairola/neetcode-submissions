class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
        }
        if (totalSum < target || (totalSum - target) % 2 != 0) {
            return 0;
        }

        return dfs(n - 1, (totalSum - target) / 2, nums);
    }

    private int dfs(int ind, int target, int[] nums) {
        if (ind == 0) {
            int res = 0;
            if (nums[0] == 0 && target == 0)
                return 2;
            if (target == nums[0] || target == 0)
                return 1;
            return 0;
        }
        int take = 0;
        if (target >= nums[ind])
            take = dfs(ind - 1, target - nums[ind], nums);
        int notTake = dfs(ind - 1, target, nums);
        return take + notTake;
    }
}
