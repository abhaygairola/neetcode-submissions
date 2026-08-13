class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int l = nums.length;
        for (int i = 0; i < l - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int j = i + 1;
            int k = l - 1;
            while (j < k) {
                int diff = (nums[i] + nums[j] + nums[k]);
                if (diff > 0)
                    k--;
                else if (diff < 0)
                    j++;
                else {
                    List<Integer> a = Arrays.asList(nums[i], nums[j], nums[k]);
                    res.add(a);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) {
                    j++;
                    }
                }
            }
        }
        return res;
    }
}
