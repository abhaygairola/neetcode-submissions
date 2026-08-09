class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> comp = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int t = target - nums[i];
            if (comp.containsKey(t)) {
                return new int[] {comp.get(t), i};
            } else {
                comp.putIfAbsent(nums[i], i);
            }
        }
        return new int[] {};
    }
}
