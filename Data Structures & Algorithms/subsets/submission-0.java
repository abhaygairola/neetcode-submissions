class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        res.add(cur);
        dfs(nums, res, cur, 0);
        return res;
    }

    void dfs(int[] nums, List<List<Integer>> res, List<Integer> cur, int i) {
        if (i >= nums.length)
            return;
        dfs(nums, res, cur, i + 1);
        List<Integer> mod = new ArrayList<>(cur);
        mod.add(nums[i]);
        res.add(mod);
        dfs(nums, res, mod, i + 1);
    }
}
