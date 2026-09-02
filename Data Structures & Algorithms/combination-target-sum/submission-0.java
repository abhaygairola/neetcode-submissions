class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(nums, 0, res, cur, 0, target);
        return res;
    }
    void dfs(int[] nums, int i, List<List<Integer>> res, List<Integer> cur, int sum, int target) {
        if (sum >= target || i >= nums.length)
            return;
        int newsum = sum + nums[i];
        cur.add(nums[i]);
        if (newsum == target) {
            res.add(new ArrayList<>(cur));
        }
        dfs(nums, i, res, cur, newsum, target);
        cur.remove(cur.size() - 1);

        dfs(nums, i + 1, res, cur, sum, target);
    }
}
