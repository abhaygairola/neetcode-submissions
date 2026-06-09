class Solution {
    public boolean canPartition(int[] nums) {
        int sums = sums(nums);
        if (sums % 2 != 0)
            return false;
        int n = nums.length;
        int k = sums / 2;
        boolean[] prev = new boolean[k + 1];
        boolean[] curr = new boolean[k + 1];
        prev[0]= curr[0] = true;
        if (nums[0] <= k + 1)
            prev[nums[0]] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                boolean ntk = prev[j];
                boolean tk = false;
                if (nums[i] <= j) {
                    tk = prev[j - nums[i]];
                }

                curr[j] = (tk || ntk);
            }
            prev=curr;
            curr= new boolean[k + 1];
            curr[0] = true;
        }

        return prev[k];
    }

    private int sums(int[] nums) {
        int tl = 0;
        for (int i = 0; i < nums.length; i++) {
            tl += nums[i];
        }
        return tl;
    }
}
