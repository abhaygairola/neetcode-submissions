class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), nums, 0);
        return res;
    }

    void dfs(List<List<Integer>> res, List<Integer> cur, int[] nums, int ind) {
        res.add(new ArrayList<>(cur));
        for (int i = ind; i < nums.length; i++) {
            if (i > ind && nums[i] == nums[i - 1])
                continue;
            cur.add(nums[i]);
            dfs(res, cur, nums, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
