class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res,nums, 0);
        return res;
    }

    void dfs(List<List<Integer>> res, int[] nums, int ind) {
        if (nums.length == ind) {
            List<Integer>a = new ArrayList<>();
            for(int n:nums){a.add(n);}
            res.add(a);
            return;
        }

        for (int i = ind; i < nums.length; i++) {
            swap(nums, ind, i);
            dfs(res, nums, ind + 1);
            swap(nums, ind, i);
        }
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
