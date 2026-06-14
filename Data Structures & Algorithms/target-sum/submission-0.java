class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums.length-1, target, nums);
    }
    public int dfs(int ind, int target, int[] nums) {
        if (ind == 0) {
            int res = 0;
            if (target + nums[ind] == 0) {
                res++;
            }
            if (target - nums[ind] == 0) {
                res++;
            }
            return res;
        }
        int posTake = dfs(ind - 1, target + nums[ind], nums);
        int negTake = dfs(ind - 1, target - nums[ind], nums);
        return posTake + negTake;
    }
}
