class Solution {
    public int jump(int[] nums) {
        int l = 0, r = 0, cnt = 0;
        while (r < nums.length - 1) {
            int maxW = -1;
            for (int i = l; i <= r; i++) {
                maxW = Math.max(maxW, i + nums[i]);
            }
            cnt++;
            l = r + 1;
            r = maxW;
        }
        return cnt;
    }
}
