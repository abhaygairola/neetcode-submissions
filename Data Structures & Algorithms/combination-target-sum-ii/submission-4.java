class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, 0, res, new ArrayList<>(), 0, target);
        return res;
    }
    void dfs(int[] nums, int i, List<List<Integer>> res, List<Integer> cur, int sum, int target) {

        if(sum == target){res.add(new ArrayList<>(cur));return;}
        for (int ind = i; ind < nums.length; ind++) {
            if (ind > i && nums[ind - 1] == nums[ind])
                continue;
            if (nums[ind] > target-sum)
                break;

            cur.add(nums[ind]);
            dfs(nums, ind + 1, res, cur, sum + nums[ind], target);
            cur.remove(cur.size() - 1);
        }
    }
}
