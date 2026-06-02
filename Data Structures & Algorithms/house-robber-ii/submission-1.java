class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n==1) return nums[0];
        return Math.max(rob2(nums,0,n-2),rob2(nums,1,n-1));

    }
    public int rob2(int[] nums,int s,int e) {
        int n = e-s+1;
        int prev = nums[s];
        int prev2 = 0;
        for (int i = s+1; i <= e; i++) {
            int pick = nums[i] + prev2;
            int notPick = prev;
            int temp = Math.max(pick, notPick);
            prev2 = prev;
            prev = temp;
        }
        return prev;
    }
}