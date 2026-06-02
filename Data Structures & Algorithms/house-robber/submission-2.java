class Solution {
    public int rob(int[] nums) {
        int n =nums.length;
        int [] dp = new int[n];
        int prev =nums[0];
        int prev2 =0;
        for(int i =1;i<n;i++){
            int pick = nums[i]+prev2;
            int notPick = prev;
            int temp = Math.max(pick,notPick);
            prev2=prev;prev=temp;
        }

        return prev;
        
    }
}
