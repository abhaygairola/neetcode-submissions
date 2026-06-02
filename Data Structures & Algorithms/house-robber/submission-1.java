class Solution {
    public int rob(int[] nums) {
        int n =nums.length;
        int [] dp = new int[n];
        dp[0]=nums[0];
        for(int i =1;i<n;i++){
            int pick = (i!=1)?nums[i]+dp[i-2]:nums[i];
            int notPick = dp[i-1];
            dp[i] = Math.max(pick,notPick);
        }

        return dp[n-1];


        
    }
}
